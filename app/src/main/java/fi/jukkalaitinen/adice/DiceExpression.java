package fi.jukkalaitinen.adice;

/* A Bison parser, made by GNU Bison 3.4.1.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */




/* "%code imports" blocks.  */
/* "DiceExpression.y":10  */

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/* "DiceExpression.java":51  */

/**
 * A Bison parser, automatically generated from <tt>DiceExpression.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class DiceExpression
{
    /** Version number for the Bison executable that generated this parser.  */
    public static final String bisonVersion = "3.4.1";

    /** Name of the skeleton that generated this parser.  */
    public static final String bisonSkeleton = "lalr1.java";


    /**
     * True if verbose error messages are enabled.
     */
    private boolean yyErrorVerbose = true;

    /**
     * Return whether verbose error messages are enabled.
     */
    public final boolean getErrorVerbose() { return yyErrorVerbose; }

    /**
     * Set the verbosity of error messages.
     * @param verbose True to request verbose error messages.
     */
    public final void setErrorVerbose(boolean verbose)
    { yyErrorVerbose = verbose; }



    /**
     * A class defining a pair of positions.  Positions, defined by the
     * <code>Position</code> class, denote a point in the input.
     * Locations represent a part of the input through the beginning
     * and ending positions.
     */
    public class Location {
        /**
         * The first, inclusive, position in the range.
         */
        public Position begin;

        /**
         * The first position beyond the range.
         */
        public Position end;

        /**
         * Create a <code>Location</code> denoting an empty range located at
         * a given point.
         * @param loc The position at which the range is anchored.
         */
        public Location (Position loc) {
            this.begin = this.end = loc;
        }

        /**
         * Create a <code>Location</code> from the endpoints of the range.
         * @param begin The first position included in the range.
         * @param end   The first position beyond the range.
         */
        public Location (Position begin, Position end) {
            this.begin = begin;
            this.end = end;
        }

        /**
         * Print a representation of the location.  For this to be correct,
         * <code>Position</code> should override the <code>equals</code>
         * method.
         */
        public String toString () {
            if (begin.equals (end))
                return begin.toString ();
            else
                return begin.toString () + "-" + end.toString ();
        }
    }




    private Location yylloc (YYStack rhs, int n)
    {
        if (n > 0)
            return new Location (rhs.locationAt (n-1).begin, rhs.locationAt (0).end);
        else
            return new Location (rhs.locationAt (0).end);
    }

    /**
     * Communication interface between the scanner and the Bison-generated
     * parser <tt>DiceExpression</tt>.
     */
    public interface Lexer {
        /** Token returned by the scanner to signal the end of its input.  */
        public static final int EOF = 0;

        /* Tokens.  */
        /** Token number,to be returned by the scanner.  */
        static final int INTEGER = 258;
        /** Token number,to be returned by the scanner.  */
        static final int INVALID_CHARACTER = 259;
        /** Token number,to be returned by the scanner.  */
        static final int OVERFLOW = 260;
        /** Token number,to be returned by the scanner.  */
        static final int IGNORE_EMPTY = 261;
        /** Token number,to be returned by the scanner.  */
        static final int UMINUS = 262;
        /** Token number,to be returned by the scanner.  */
        static final int UPLUS = 263;


        /**
         * Method to retrieve the beginning position of the last scanned token.
         * @return the position at which the last scanned token starts.
         */
        Position getStartPos ();

        /**
         * Method to retrieve the ending position of the last scanned token.
         * @return the first position beyond the last scanned token.
         */
        Position getEndPos ();

        /**
         * Method to retrieve the semantic value of the last scanned token.
         * @return the semantic value of the last scanned token.
         */
        Object getLVal ();

        /**
         * Entry point for the scanner.  Returns the token identifier corresponding
         * to the next token and prepares to return the semantic value
         * and beginning/ending positions of the token.
         * @return the token identifier corresponding to the next token.
         */
        int yylex () throws java.io.IOException;

        /**
         * Entry point for error reporting.  Emits an error
         * referring to the given location in a user-defined way.
         *
         * @param loc The location of the element to which the
         *                error message is related
         * @param msg The string for the error message.
         */
        void yyerror (Location loc, String msg);
    }

    /**
     * The object doing lexical analysis for us.
     */
    private Lexer yylexer;





    /**
     * Instantiates the Bison-generated parser.
     * @param yylexer The scanner that will supply tokens to the parser.
     */
    public DiceExpression (Lexer yylexer)
    {

        this.yylexer = yylexer;

    }

    private java.io.PrintStream yyDebugStream = System.err;

    /**
     * Return the <tt>PrintStream</tt> on which the debugging output is
     * printed.
     */
    public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

    /**
     * Set the <tt>PrintStream</tt> on which the debug output is printed.
     * @param s The stream that is used for debugging output.
     */
    public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

    private int yydebug = 0;

    /**
     * Answer the verbosity of the debugging output; 0 means that all kinds of
     * output from the parser are suppressed.
     */
    public final int getDebugLevel() { return yydebug; }

    /**
     * Set the verbosity of the debugging output; 0 means that all kinds of
     * output from the parser are suppressed.
     * @param level The verbosity level for debugging output.
     */
    public final void setDebugLevel(int level) { yydebug = level; }

    /**
     * Print an error message via the lexer.
     * Use a <code>null</code> location.
     * @param msg The error message.
     */
    public final void yyerror (String msg)
    {
        yylexer.yyerror ((Location)null, msg);
    }

    /**
     * Print an error message via the lexer.
     * @param loc The location associated with the message.
     * @param msg The error message.
     */
    public final void yyerror (Location loc, String msg)
    {
        yylexer.yyerror (loc, msg);
    }

    /**
     * Print an error message via the lexer.
     * @param pos The position associated with the message.
     * @param msg The error message.
     */
    public final void yyerror (Position pos, String msg)
    {
        yylexer.yyerror (new Location (pos), msg);
    }

    protected final void yycdebug (String s) {
        if (yydebug > 0)
            yyDebugStream.println (s);
    }

    private final class YYStack {
        private int[] stateStack = new int[16];
        private Location[] locStack = new Location[16];
        private Object[] valueStack = new Object[16];

        public int size = 16;
        public int height = -1;

        public final void push (int state, Object value                            , Location loc) {
            height++;
            if (size == height)
            {
                int[] newStateStack = new int[size * 2];
                System.arraycopy (stateStack, 0, newStateStack, 0, height);
                stateStack = newStateStack;

                Location[] newLocStack = new Location[size * 2];
                System.arraycopy (locStack, 0, newLocStack, 0, height);
                locStack = newLocStack;

                Object[] newValueStack = new Object[size * 2];
                System.arraycopy (valueStack, 0, newValueStack, 0, height);
                valueStack = newValueStack;

                size *= 2;
            }

            stateStack[height] = state;
            locStack[height] = loc;
            valueStack[height] = value;
        }

        public final void pop () {
            pop (1);
        }

        public final void pop (int num) {
            // Avoid memory leaks... garbage collection is a white lie!
            if (num > 0) {
                java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
                java.util.Arrays.fill (locStack, height - num + 1, height + 1, null);
            }
            height -= num;
        }

        public final int stateAt (int i) {
            return stateStack[height - i];
        }

        public final Location locationAt (int i) {
            return locStack[height - i];
        }

        public final Object valueAt (int i) {
            return valueStack[height - i];
        }

        // Print the state stack on the debug stream.
        public void print (java.io.PrintStream out) {
            out.print ("Stack now");

            for (int i = 0; i <= height; i++)
            {
                out.print (' ');
                out.print (stateStack[i]);
            }
            out.println ();
        }
    }

    /**
     * Returned by a Bison action in order to stop the parsing process and
     * return success (<tt>true</tt>).
     */
    public static final int YYACCEPT = 0;

    /**
     * Returned by a Bison action in order to stop the parsing process and
     * return failure (<tt>false</tt>).
     */
    public static final int YYABORT = 1;



    /**
     * Returned by a Bison action in order to start error recovery without
     * printing an error message.
     */
    public static final int YYERROR = 2;

    /**
     * Internal return codes that are not supported for user semantic
     * actions.
     */
    private static final int YYERRLAB = 3;
    private static final int YYNEWSTATE = 4;
    private static final int YYDEFAULT = 5;
    private static final int YYREDUCE = 6;
    private static final int YYERRLAB1 = 7;
    private static final int YYRETURN = 8;


    private int yyerrstatus_ = 0;


    /**
     * Return whether error recovery is being done.  In this state, the parser
     * reads token until it reaches a known state, and then restarts normal
     * operation.
     */
    public final boolean recovering ()
    {
        return yyerrstatus_ == 0;
    }

    /** Compute post-reduction state.
     * @param yystate   the current state
     * @param yysym     the nonterminal to push on the stack
     */
    private int yy_lr_goto_state_ (int yystate, int yysym)
    {
        int yyr = yypgoto_[yysym - yyntokens_] + yystate;
        if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
            return yytable_[yyr];
        else
            return yydefgoto_[yysym - yyntokens_];
    }

    private int yyaction (int yyn, YYStack yystack, int yylen) throws Exception
    {
        Object yyval;
        Location yyloc = yylloc (yystack, yylen);

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
        if (yylen > 0)
            yyval = yystack.valueAt (yylen - 1);
        else
            yyval = yystack.valueAt (0);

        yy_reduce_print (yyn, yystack);

        switch (yyn)
        {
            case 2:
                if (yyn == 2)
                    /* "DiceExpression.y":86  */
                {
                    result = (int) yystack.valueAt (0);
                };
                break;


            case 3:
                if (yyn == 3)
                    /* "DiceExpression.y":92  */
                {
                    error = "Invalid character";
                    return YYERROR;
                };
                break;


            case 4:
                if (yyn == 4)
                    /* "DiceExpression.y":97  */
                {
                    error = "Integer overflow";
                    return YYERROR;
                };
                break;


            case 5:
                if (yyn == 5)
                    /* "DiceExpression.y":102  */
                {
                    resultString.string += yystack.valueAt (0);
                    yyval = yystack.valueAt (0);
                };
                break;


            case 6:
                if (yyn == 6)
                    /* "DiceExpression.y":107  */
                {
                    resultString.string += "-";
                };
                break;


            case 7:
                if (yyn == 7)
                    /* "DiceExpression.y":109  */
                {
                    yyval = new Integer(-(int) yystack.valueAt (0));
                };
                break;


            case 8:
                if (yyn == 8)
                    /* "DiceExpression.y":113  */
                {
                    resultString.string += "+";
                };
                break;


            case 9:
                if (yyn == 9)
                    /* "DiceExpression.y":115  */
                { yyval = new Integer((int) yystack.valueAt (0)); };
                break;


            case 10:
                if (yyn == 10)
                    /* "DiceExpression.y":117  */
                {
                    resultString.string += "-";
                };
                break;


            case 11:
                if (yyn == 11)
                    /* "DiceExpression.y":119  */
                {
                    yyval = new Integer((int) yystack.valueAt (3) - (int) yystack.valueAt (0));
                };
                break;


            case 12:
                if (yyn == 12)
                    /* "DiceExpression.y":123  */
                {
                    resultString.string += "+";
                };
                break;


            case 13:
                if (yyn == 13)
                    /* "DiceExpression.y":125  */
                {
                    yyval = new Integer((int) yystack.valueAt (3) + (int) yystack.valueAt (0));
                };
                break;


            case 14:
                if (yyn == 14)
                    /* "DiceExpression.y":129  */
                {
                    try {
                        int sum = roll((int) yystack.valueAt (3), (int) yystack.valueAt (1), ignoreSmall, ignoreLarge, resultString);
                        yyval = sum;
                    }
                    catch (Exception e) {
                        error = e.toString();
                        return YYERROR;
                    }
                    finally {
                        ignoreSmall = 0;
                        ignoreLarge = 0;
                    }
                };
                break;


            case 15:
                if (yyn == 15)
                    /* "DiceExpression.y":146  */
                { yyval = new Integer((int) yystack.valueAt (0)); };
                break;


            case 16:
                if (yyn == 16)
                    /* "DiceExpression.y":148  */
                { yyval = 1; };
                break;


            case 20:
                if (yyn == 20)
                    /* "DiceExpression.y":158  */
                {
                    ignoreSmall++;
                };
                break;


            case 21:
                if (yyn == 21)
                    /* "DiceExpression.y":162  */
                {
                    ignoreLarge++;
                };
                break;


            case 22:
                if (yyn == 22)
                    /* "DiceExpression.y":166  */
                {
                    ignoreSmall += new Integer((int) yystack.valueAt (0));
                };
                break;


            case 23:
                if (yyn == 23)
                    /* "DiceExpression.y":170  */
                {
                    ignoreLarge += new Integer((int) yystack.valueAt (0));
                };
                break;



            /* "DiceExpression.java":618  */

            default: break;
        }

        yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval, yyloc);

        yystack.pop (yylen);
        yylen = 0;

        /* Shift the result of the reduction.  */
        int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
        yystack.push (yystate, yyval, yyloc);
        return YYNEWSTATE;
    }


    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private final String yytnamerr_ (String yystr)
    {
        if (yystr.charAt (0) == '"')
        {
            StringBuffer yyr = new StringBuffer ();
            strip_quotes: for (int i = 1; i < yystr.length (); i++)
                switch (yystr.charAt (i))
                {
                    case '\'':
                    case ',':
                        break strip_quotes;

                    case '\\':
                        if (yystr.charAt(++i) != '\\')
                            break strip_quotes;
                        /* Fall through.  */
                    default:
                        yyr.append (yystr.charAt (i));
                        break;

                    case '"':
                        return yyr.toString ();
                }
        }
        else if (yystr.equals ("$end"))
            return "end of input";

        return yystr;
    }


  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

    private void yy_symbol_print (String s, int yytype,
                                  Object yyvaluep                                 , Object yylocationp)
    {
        if (yydebug > 0)
            yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
                    + yytname_[yytype] + " ("
                    + yylocationp + ": "
                    + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
    }


    /**
     * Parse input from the scanner that was specified at object construction
     * time.  Return whether the end of the input was reached successfully.
     *
     * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
     *          imply that there were no syntax errors.
     */
    public boolean parse () throws java.io.IOException, Exception

    {
        /* @$.  */
        Location yyloc;


        /* Lookahead and lookahead in internal form.  */
        int yychar = yyempty_;
        int yytoken = 0;

        /* State.  */
        int yyn = 0;
        int yylen = 0;
        int yystate = 0;
        YYStack yystack = new YYStack ();
        int label = YYNEWSTATE;

        /* Error handling.  */
        int yynerrs_ = 0;
        /* The location where the error started.  */
        Location yyerrloc = null;

        /* Location. */
        Location yylloc = new Location (null, null);

        /* Semantic value of the lookahead.  */
        Object yylval = null;

        yycdebug ("Starting parse\n");
        yyerrstatus_ = 0;

        /* Initialize the stack.  */
        yystack.push (yystate, yylval , yylloc);



        for (;;)
            switch (label)
            {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
                case YYNEWSTATE:
                    yycdebug ("Entering state " + yystate + "\n");
                    if (yydebug > 0)
                        yystack.print (yyDebugStream);

                    /* Accept?  */
                    if (yystate == yyfinal_)
                        return true;

                    /* Take a decision.  First try without lookahead.  */
                    yyn = yypact_[yystate];
                    if (yy_pact_value_is_default_ (yyn))
                    {
                        label = YYDEFAULT;
                        break;
                    }

                    /* Read a lookahead token.  */
                    if (yychar == yyempty_)
                    {


                        yycdebug ("Reading a token: ");
                        yychar = yylexer.yylex ();
                        yylval = yylexer.getLVal ();
                        yylloc = new Location (yylexer.getStartPos (),
                                yylexer.getEndPos ());

                    }

                    /* Convert token to internal form.  */
                    if (yychar <= Lexer.EOF)
                    {
                        yychar = yytoken = Lexer.EOF;
                        yycdebug ("Now at end of input.\n");
                    }
                    else
                    {
                        yytoken = yytranslate_ (yychar);
                        yy_symbol_print ("Next token is", yytoken,
                                yylval, yylloc);
                    }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
                    yyn += yytoken;
                    if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
                        label = YYDEFAULT;

                        /* <= 0 means reduce or error.  */
                    else if ((yyn = yytable_[yyn]) <= 0)
                    {
                        if (yy_table_value_is_error_ (yyn))
                            label = YYERRLAB;
                        else
                        {
                            yyn = -yyn;
                            label = YYREDUCE;
                        }
                    }

                    else
                    {
                        /* Shift the lookahead token.  */
                        yy_symbol_print ("Shifting", yytoken,
                                yylval, yylloc);

                        /* Discard the token being shifted.  */
                        yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
                        if (yyerrstatus_ > 0)
                            --yyerrstatus_;

                        yystate = yyn;
                        yystack.push (yystate, yylval, yylloc);
                        label = YYNEWSTATE;
                    }
                    break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
                case YYDEFAULT:
                    yyn = yydefact_[yystate];
                    if (yyn == 0)
                        label = YYERRLAB;
                    else
                        label = YYREDUCE;
                    break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
                case YYREDUCE:
                    yylen = yyr2_[yyn];
                    label = yyaction (yyn, yystack, yylen);
                    yystate = yystack.stateAt (0);
                    break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
                case YYERRLAB:
                    /* If not already recovering from an error, report this error.  */
                    if (yyerrstatus_ == 0)
                    {
                        ++yynerrs_;
                        if (yychar == yyempty_)
                            yytoken = yyempty_;
                        yyerror (yylloc, yysyntax_error (yystate, yytoken));
                    }

                    yyerrloc = yylloc;
                    if (yyerrstatus_ == 3)
                    {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

                        if (yychar <= Lexer.EOF)
                        {
                            /* Return failure if at end of input.  */
                            if (yychar == Lexer.EOF)
                                return false;
                        }
                        else
                            yychar = yyempty_;
                    }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
                    label = YYERRLAB1;
                    break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
                case YYERROR:

                    yyerrloc = yystack.locationAt (yylen - 1);
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
                    yystack.pop (yylen);
                    yylen = 0;
                    yystate = yystack.stateAt (0);
                    label = YYERRLAB1;
                    break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
                case YYERRLAB1:
                    yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

                    for (;;)
                    {
                        yyn = yypact_[yystate];
                        if (!yy_pact_value_is_default_ (yyn))
                        {
                            yyn += yyterror_;
                            if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                            {
                                yyn = yytable_[yyn];
                                if (0 < yyn)
                                    break;
                            }
                        }

                        /* Pop the current state because it cannot handle the
                         * error token.  */
                        if (yystack.height == 0)
                            return false;

                        yyerrloc = yystack.locationAt (0);
                        yystack.pop ();
                        yystate = yystack.stateAt (0);
                        if (yydebug > 0)
                            yystack.print (yyDebugStream);
                    }

                    if (label == YYABORT)
                        /* Leave the switch.  */
                        break;


                    /* Muck with the stack to setup for yylloc.  */
                    yystack.push (0, null, yylloc);
                    yystack.push (0, null, yyerrloc);
                    yyloc = yylloc (yystack, 2);
                    yystack.pop (2);

                    /* Shift the error token.  */
                    yy_symbol_print ("Shifting", yystos_[yyn],
                            yylval, yyloc);

                    yystate = yyn;
                    yystack.push (yyn, yylval, yyloc);
                    label = YYNEWSTATE;
                    break;

                /* Accept.  */
                case YYACCEPT:
                    return true;

                /* Abort.  */
                case YYABORT:
                    return false;
            }
    }




    // Generate an error message.
    private String yysyntax_error (int yystate, int tok)
    {
        if (yyErrorVerbose)
        {
        /* There are many possibilities here to consider:
           - If this state is a consistent state with a default action,
             then the only way this function was invoked is if the
             default action is an error action.  In that case, don't
             check for expected tokens because there are none.
           - The only way there can be no lookahead present (in tok) is
             if this state is a consistent state with a default action.
             Thus, detecting the absence of a lookahead is sufficient to
             determine that there is no unexpected or expected token to
             report.  In that case, just report a simple "syntax error".
           - Don't assume there isn't a lookahead just because this
             state is a consistent state with a default action.  There
             might have been a previous inconsistent state, consistent
             state with a non-default action, or user semantic action
             that manipulated yychar.  (However, yychar is currently out
             of scope during semantic actions.)
           - Of course, the expected token list depends on states to
             have correct lookahead information, and it depends on the
             parser not to perform extra reductions after fetching a
             lookahead from the scanner and before detecting a syntax
             error.  Thus, state merging (from LALR or IELR) and default
             reductions corrupt the expected token list.  However, the
             list is correct for canonical LR with one exception: it
             will still contain any token that will not be accepted due
             to an error action in a later state.
        */
            if (tok != yyempty_)
            {
            /* FIXME: This method of building the message is not compatible
               with internationalization.  */
                StringBuffer res =
                        new StringBuffer ("syntax error, unexpected ");
                res.append (yytnamerr_ (yytname_[tok]));
                int yyn = yypact_[yystate];
                if (!yy_pact_value_is_default_ (yyn))
                {
                /* Start YYX at -YYN if negative to avoid negative
                   indexes in YYCHECK.  In other words, skip the first
                   -YYN actions for this state because they are default
                   actions.  */
                    int yyxbegin = yyn < 0 ? -yyn : 0;
                    /* Stay within bounds of both yycheck and yytname.  */
                    int yychecklim = yylast_ - yyn + 1;
                    int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
                    int count = 0;
                    for (int x = yyxbegin; x < yyxend; ++x)
                        if (yycheck_[x + yyn] == x && x != yyterror_
                                && !yy_table_value_is_error_ (yytable_[x + yyn]))
                            ++count;
                    if (count < 5)
                    {
                        count = 0;
                        for (int x = yyxbegin; x < yyxend; ++x)
                            if (yycheck_[x + yyn] == x && x != yyterror_
                                    && !yy_table_value_is_error_ (yytable_[x + yyn]))
                            {
                                res.append (count++ == 0 ? ", expecting " : " or ");
                                res.append (yytnamerr_ (yytname_[x]));
                            }
                    }
                }
                return res.toString ();
            }
        }

        return "syntax error";
    }

    /**
     * Whether the given <code>yypact_</code> value indicates a defaulted state.
     * @param yyvalue   the value to check
     */
    private static boolean yy_pact_value_is_default_ (int yyvalue)
    {
        return yyvalue == yypact_ninf_;
    }

    /**
     * Whether the given <code>yytable_</code>
     * value indicates a syntax error.
     * @param yyvalue the value to check
     */
    private static boolean yy_table_value_is_error_ (int yyvalue)
    {
        return yyvalue == yytable_ninf_;
    }

    private static final byte yypact_ninf_ = -10;
    private static final byte yytable_ninf_ = -16;

    /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
    private static final byte yypact_[] = yypact_init();
    private static final byte[] yypact_init()
    {
        return new byte[]
                {
                        -1,     6,   -10,   -10,   -10,   -10,     7,     4,     8,    -1,
                        -1,   -10,   -10,   -10,    12,   -10,   -10,    -1,    -1,   -10,
                        -10,   -10,    14,    15,     3,   -10,   -10,   -10,   -10
                };
    }

    /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
       Performed when YYTABLE does not specify something else to do.  Zero
       means the default is an error.  */
    private static final byte yydefact_[] = yydefact_init();
    private static final byte[] yydefact_init()
    {
        return new byte[]
                {
                        16,     5,     3,     4,     8,     6,     0,     2,     0,    16,
                        16,     1,    12,    10,     0,     9,     7,    16,    16,    19,
                        13,    11,    20,    21,    14,    17,    22,    23,    18
                };
    }

    /* YYPGOTO[NTERM-NUM].  */
    private static final byte yypgoto_[] = yypgoto_init();
    private static final byte[] yypgoto_init()
    {
        return new byte[]
                {
                        -10,   -10,    -9,   -10,   -10,   -10,   -10,   -10,   -10,    -5
                };
    }

    /* YYDEFGOTO[NTERM-NUM].  */
    private static final byte yydefgoto_[] = yydefgoto_init();
    private static final byte[] yydefgoto_init()
    {
        return new byte[]
                {
                        -1,     6,     7,    10,     9,    18,    17,     8,    24,    25
                };
    }

    /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
       positive, shift that token.  If negative, reduce the rule whose
       number is the opposite.  If YYTABLE_NINF, syntax error.  */
    private static final byte yytable_[] = yytable_init();
    private static final byte[] yytable_init()
    {
        return new byte[]
                {
                        15,    16,     1,     2,     3,     4,     5,    11,    20,    21,
                        12,    13,    22,    23,   -15,    19,    14,    26,    27,    28
                };
    }

    private static final byte yycheck_[] = yycheck_init();
    private static final byte[] yycheck_init()
    {
        return new byte[]
                {
                        9,    10,     3,     4,     5,     6,     7,     0,    17,    18,
                        6,     7,     9,    10,     8,     3,     8,     3,     3,    24
                };
    }

    /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
       symbol of state STATE-NUM.  */
    private static final byte yystos_[] = yystos_init();
    private static final byte[] yystos_init()
    {
        return new byte[]
                {
                        0,     3,     4,     5,     6,     7,    15,    16,    21,    18,
                        17,     0,     6,     7,     8,    16,    16,    20,    19,     3,
                        16,    16,     9,    10,    22,    23,     3,     3,    23
                };
    }

    /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
    private static final byte yyr1_[] = yyr1_init();
    private static final byte[] yyr1_init()
    {
        return new byte[]
                {
                        0,    14,    15,    16,    16,    16,    17,    16,    18,    16,
                        19,    16,    20,    16,    16,    21,    21,    22,    22,    22,
                        23,    23,    23,    23
                };
    }

    /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
    private static final byte yyr2_[] = yyr2_init();
    private static final byte[] yyr2_init()
    {
        return new byte[]
                {
                        0,     2,     1,     1,     1,     1,     0,     3,     0,     3,
                        0,     4,     0,     4,     4,     1,     0,     1,     2,     0,
                        1,     1,     2,     2
                };
    }

    /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
        to YYLEX-NUM.  */
    private static final short yytoken_number_[] = yytoken_number_init();
    private static final short[] yytoken_number_init()
    {
        return new short[]
                {
                        0,   256,   257,   258,   259,   260,    43,    45,   100,    60,
                        62,   261,   262,   263
                };
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
    private static final String yytname_[] = yytname_init();
    private static final String[] yytname_init()
    {
        return new String[]
                {
                        "$end", "error", "$undefined", "INTEGER", "INVALID_CHARACTER",
                        "OVERFLOW", "'+'", "'-'", "'d'", "'<'", "'>'", "IGNORE_EMPTY", "UMINUS",
                        "UPLUS", "$accept", "parse", "expr", "$@1", "$@2", "$@3", "$@4",
                        "maybe_int", "ignore_list", "ignore", null
                };
    }

    /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
    private static final short yyrline_[] = yyrline_init();
    private static final short[] yyrline_init()
    {
        return new short[]
                {
                        0,    86,    86,    92,    97,   102,   107,   107,   113,   113,
                        117,   117,   123,   123,   129,   146,   148,   152,   153,   154,
                        158,   162,   166,   170
                };
    }


    // Report on the debug stream that the rule yyrule is going to be reduced.
    private void yy_reduce_print (int yyrule, YYStack yystack)
    {
        if (yydebug == 0)
            return;

        int yylno = yyrline_[yyrule];
        int yynrhs = yyr2_[yyrule];
        /* Print the symbols being reduced, and their result.  */
        yycdebug ("Reducing stack by rule " + (yyrule - 1)
                + " (line " + yylno + "), ");

        /* The symbols being reduced.  */
        for (int yyi = 0; yyi < yynrhs; yyi++)
            yy_symbol_print ("   $" + (yyi + 1) + " =",
                    yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                    yystack.valueAt ((yynrhs) - (yyi + 1)),
                    yystack.locationAt ((yynrhs) - (yyi + 1)));
    }

    /* YYTRANSLATE(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
       as returned by yylex, with out-of-bounds checking.  */
    private static final byte yytranslate_table_[] = yytranslate_table_init();
    private static final byte[] yytranslate_table_init()
    {
        return new byte[]
                {
                        0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     6,     2,     7,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        9,     2,    10,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        8,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
                        2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
                        5,    11,    12,    13
                };
    }

    private static final byte yytranslate_ (int t)
    {
        if (t >= 0 && t <= yyuser_token_number_max_)
            return yytranslate_table_[t];
        else
            return yyundef_token_;
    }

    private static final int yylast_ = 19;
    private static final int yynnts_ = 10;
    private static final int yyempty_ = -2;
    private static final int yyfinal_ = 11;
    private static final int yyterror_ = 1;
    private static final int yyerrcode_ = 256;
    private static final int yyntokens_ = 14;

    private static final int yyuser_token_number_max_ = 263;
    private static final int yyundef_token_ = 2;

    /* User implementation code.  */
    /* Unqualified %code blocks.  */
    /* "DiceExpression.y":23  */

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


    /* "DiceExpression.java":1316  */

}

/* "DiceExpression.y":175  */


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


