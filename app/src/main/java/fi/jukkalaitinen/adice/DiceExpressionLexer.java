package fi.jukkalaitinen.adice;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

class DiceExpressionLexer implements DiceExpression.Lexer {

    StreamTokenizer st;
    String error;

    public DiceExpressionLexer (String s)
    {
        st = new StreamTokenizer (new StringReader(s));
        st.resetSyntax ();
        st.eolIsSignificant (true);
        st.whitespaceChars (' ', ' ');
        st.whitespaceChars ('\t', '\t');
        st.wordChars ('0', '9');
        error = null;
    }

    Position yypos = new Position (1, 0);

    public Position getStartPos() {
        return yypos;
    }

    public Position getEndPos() {
        return yypos;
    }

    public void yyerror (String m)
    {
        error = m;
        System.err.println (m);
    }

    public void yyerror (DiceExpression.Location l, String m)
    {
        if (l == null)
        {
            System.err.println (m);
            error = m;
        }
        else
        {
            System.err.println (l + ": " + m);
            error = l + ": " + m;
        }
    }

    Integer yylval;

    public Object getLVal() {
        return yylval;
    }

    public int yylex () throws IOException {
        int ttype = st.nextToken ();
        yypos = new Position (yypos.lineno (), yypos.token () + 1);

        if (ttype == st.TT_EOF)
            return EOF;

        else if (ttype == st.TT_EOL)
        {
            yypos = new Position (yypos.lineno () + 1, 0);
            return '\n';
        }

        else if (ttype == st.TT_WORD)
        {
            yylval = new Integer (st.sval);
            return INTEGER;
        }

        else
            return st.ttype;
    }
}
