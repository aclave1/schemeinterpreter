import java.io.*;

public class Main {
    // Array of token names used for debugging the scanner
    public static final String TokenName[] = {
            "QUOTE",            // '
            "LPAREN",            // (
            "RPAREN",            // )
            "DOT",                // .
            "TRUE",                // #t
            "FALSE",            // #f
            "INT",                // integer constant
            "STRING",            // string constant
            "IDENT"                // identifier
    };

    public static void main(String argv[]) {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        //set to true if you want to provided a filepath instead of using < (redirection)
        boolean readFromFilePath = false;
        boolean debugScanner = false;
        String filename = null;
        for (int i = 0; i < argv.length; i++) {
            if (argv[i].equals("-d")) {
                debugScanner = true;
            } else if (argv[i].equals("-f") && i < argv.length) {
                readFromFilePath = true;
                filename = argv[++i];
            }
        }

        if (readFromFilePath == true) {
            try {
                System.setIn(new FileInputStream(filename));
            } catch (Exception e) {
                System.out.println("failure");
            }
        }
        // create scanner that reads from standard input
        TokenScanner tokenScanner = new TokenScanner(System.in);


        if (debugScanner == true) {
            // debug scanner
            Token tok = tokenScanner.getNextToken();
            while (tok != null) {
                int tt = tok.getType();
                System.out.print(TokenName[tt]);
                if (tt == Token.INT)
                    System.out.println(", intVal = " + tok.getIntVal());
                else if (tt == Token.STRING)
                    System.out.println(", strVal = " + tok.getStrVal());
                else if (tt == Token.IDENT)
                    System.out.println(", name = " + tok.getName());
                else
                    System.out.println();
                tok = tokenScanner.getNextToken();
            }
        }

        // Create parser
        Parser parser = new Parser(tokenScanner);


        Environment builtinEnv = new Environment();
        defineBuiltins(builtinEnv);
        Environment globalEnv = new Environment(builtinEnv);


        // Parse and pretty-print each input expression
        Node root = new Nil();
        try {
            root = parser.parseExp();
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.printf(InterpreterMessages.INVALID_EOF);
        }
        while (root != null) {
            try {
                Node results = root.eval(root, globalEnv);
                if (results != null) {
                    results.print(0);
                } else {
                    System.out.printf("no values returned");
                }

            } catch (Exception e) {

            }
            System.out.printf("\n");
            root = parser.parseExp();
        }
        System.exit(0);
    }

    public static void defineBuiltins(Environment env) {

        /**specials*/
        Ident elseClause = new Ident(Keywords.ELSE);
        env.define(elseClause, new Else());

        /**
         * binary arithmetic
         */
        Ident binaryPlus = new Ident(Keywords.BINARY_PLUS);
        env.define(binaryPlus, new BuiltInAddition(binaryPlus));

        Ident binaryMinus = new Ident(Keywords.BINARY_MINUS);
        env.define(binaryMinus, new BuiltInSubtraction(binaryMinus));

        Ident binaryMult = new Ident(Keywords.BINARY_MULT);
        env.define(binaryMult, new BuiltinMultiplication(binaryMult));

        Ident binaryDiv = new Ident(Keywords.BINARY_DIV);
        env.define(binaryDiv, new BuiltInDivision(binaryDiv));

        Ident binaryEquals = new Ident(Keywords.BINARY_ARITHMETIC_EQUALS);
        env.define(binaryEquals, new BuiltInEquals(binaryEquals));

        Ident binaryLessThan = new Ident(Keywords.BINARY_LT);
        env.define(binaryLessThan, new BuiltInLessThan(binaryLessThan));


        /**type checks*/
        Ident isSymbol = new Ident(Keywords.SYMBOLCHECK);
        env.define(isSymbol, new BuiltInSymbolCheck(isSymbol));

        Ident isNumber = new Ident(Keywords.NUMBERCHECK);
        env.define(isNumber, new BuiltInNumberCheck(isNumber));

        Ident isProcedure = new Ident(Keywords.PROCEDURECHECK);
        env.define(isProcedure, new BuiltInProcedureCheck(isProcedure));


        /**list operations*/

        Ident car = new Ident(Keywords.CAR);
        env.define(car, new BuiltInCar(car));
        Ident cdr = new Ident(Keywords.CDR);
        env.define(cdr, new BuiltInCdr(cdr));

        Ident setCar = new Ident(Keywords.SET_CAR);
        env.define(setCar, new BuiltInSetCar(setCar));
        Ident setCdr = new Ident(Keywords.SET_CDR);
        env.define(setCdr, new BuiltInSetCdr(setCdr));
        Ident pairCheck = new Ident(Keywords.PAIRCHECK);
        env.define(pairCheck, new BuiltInPairCheck(pairCheck));
        Ident nullCheck = new Ident(Keywords.NULLCHECK);
        env.define(nullCheck, new BuiltInNullCheck(nullCheck));


        /**cons*/
        Ident cons = new Ident(Keywords.CONS);
        env.define(cons, new BuiltInCons(cons));
        Ident quote = new Ident(Keywords.QUOTE);
        env.define(quote, new BuiltInCons(quote));
        Ident quoteWord = new Ident(Keywords.QUOTE_WORD);
        env.define(quoteWord, new BuiltInCons(quoteWord));

        Ident eq = new Ident(Keywords.OBJECT_EQUALS);
        env.define(eq, new BuiltInObjectEquals(eq));


        /**eval, apply, interaction-environment*/
        Ident eval = new Ident(Keywords.EVAL);
        env.define(eval, new BuiltInEval(eval));

        Ident apply = new Ident(Keywords.APPLY);
        env.define(apply, new BuiltInApply(apply));

        Ident interEnv = new Ident(Keywords.INTERACTION_ENVIRONMENT);
        env.define(interEnv, new BuiltInInteractionEnvironment(interEnv));


        /**io*/

        Ident newline = new Ident(Keywords.IONEWLINE);
        env.define(newline,new BuiltInNewLine(newline));

        Ident read = new Ident(Keywords.IOREAD);
        env.define(read,new BuiltInRead(read));

        Ident write = new Ident(Keywords.IOWRITE);
        env.define(write,new BuiltInWrite(write));

        Ident display = new Ident(Keywords.IODISPLAY);
        env.define(display,new BuiltInDisplay(display));

    }


}
