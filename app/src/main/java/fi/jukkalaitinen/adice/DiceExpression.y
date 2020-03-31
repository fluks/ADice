%language "Java"
%locations
%debug
%define parse.error verbose
%define api.prefix {DiceExpression}
%define api.parser.class {DiceExpression}
%define api.parser.public
%define throws {Exception}

%code imports {
  import java.io.StreamTokenizer;
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.StringReader;
  import java.io.IOException;
  import java.util.Random;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Collections;
}

%code {
    public class ResultString {
      public String string;

      public ResultString() {
          string = "";
      }
    }

    ResultString resultString = new ResultString();
    int result = 0;
    String error = "";
    int ignoreSmall = 0;
    int ignoreLarge = 0;

  public int roll(int nrolls, int dice, int ignoreLarge, int ignoreSmall, ResultString rs) throws Exception {
      List<Integer> rolls = new ArrayList<Integer>();
      Random rand = new Random();
      for (int i = 0; i < nrolls; i++) {
          Integer n = rand.nextInt(dice) + 1;
          rolls.add(n);
      }

      Collections.sort(rolls);
      if (ignoreSmall + ignoreLarge >= nrolls || ignoreSmall >= nrolls || ignoreLarge >= nrolls)
          throw new Exception("Too many ignores");
      if (ignoreSmall > 0)
          rolls = rolls.subList(ignoreSmall, rolls.size());
      if (ignoreLarge > 0)
          rolls = rolls.subList(0, rolls.size() - ignoreLarge);

      int sum = 0;
      for (Integer i : rolls) {
          sum += i;
      }

      resultString.string += "(";
      for (Integer i : rolls) {
          resultString.string += i + "+";
      }
      resultString.string = resultString.string.substring(0, resultString.string.length() - 1);
      resultString.string += ")";

      return sum;
  }

}

/* Bison Declarations */
%token INTEGER
%token INVALID_CHARACTER OVERFLOW

%left '+' '-'
%nonassoc 'd'
%right '<' '>'

%nonassoc IGNORE_EMPTY
%nonassoc UMINUS UPLUS

/* Grammar follows */
%%

parse:
    expr {
        result = (int) $1;
    }
    ;

expr:
    INVALID_CHARACTER {
        error = "Invalid character";
        return YYERROR;
    }

    | OVERFLOW {
        error = "Integer overflow";
        return YYERROR;
    }

    | INTEGER {
        resultString.string += $1;
        $$ = $1;
    }

    | '-' {
        resultString.string += "-";
    } expr %prec UMINUS  {
        $$ = new Integer(-(int) $3);
    }

    | '+' {
        resultString.string += "+";
    } expr %prec UPLUS { $$ = new Integer((int) $3); }

    | expr '-' {
        resultString.string += "-";
    } expr {
        $$ = new Integer((int) $1 - (int) $4);
    }

    | expr '+' {
        resultString.string += "+";
    } expr {
        $$ = new Integer((int) $1 + (int) $4);
    }

    | maybe_int 'd' INTEGER ignore_list {
        try {
            int sum = roll((int) $1, (int) $3, ignoreSmall, ignoreLarge, resultString);
            $$ = sum;
        }
        catch (Exception e) {
            error = e.toString();
            return YYERROR;
        }
        finally {
            ignoreSmall = 0;
            ignoreLarge = 0;
        }
    }
    ;

maybe_int:
    INTEGER { $$ = new Integer((int) $1); }
    /* If there's no number before 'd', roll the dice one time. */
    |       { $$ = 1; }
    ;

ignore_list:
    ignore
    | ignore_list ignore
    | %prec IGNORE_EMPTY
    ;

ignore:
    '<' {
        ignoreSmall++;
    }

    | '>' {
        ignoreLarge++;
    }

    | '<' INTEGER {
        ignoreSmall += new Integer((int) $2);
    }

    | '>' INTEGER {
        ignoreLarge += new Integer((int) $2);
    }
    ;

%%
class DiceExpressionLexer implements DiceExpression.Lexer {

  StreamTokenizer st;
  String error;

  public DiceExpressionLexer (String s)
  {
    st = new StreamTokenizer (new StringReader (s));
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

class Position {
  public int line;
  public int token;

  public Position ()
  {
    line = 0;
    token = 0;
  }

  public Position (int l, int t)
  {
    line = l;
    token = t;
  }

  public boolean equals (Position l)
  {
    return l.line == line && l.token == token;
  }

  public String toString ()
  {
    return Integer.toString (line) + "." + Integer.toString(token);
  }

  public int lineno ()
  {
    return line;
  }

  public int token ()
  {
    return token;
  }
}
