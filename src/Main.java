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
        Environment globalEnv = new Environment(builtinEnv);

        defineBuiltins(builtinEnv);





        // Parse and pretty-print each input expression
        Node root = new Nil();
        try {
            root = parser.parseExp();
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.printf(InterpreterMessages.INVALID_EOF);
        }
        while (root != null) {
            Node results = root.eval(root,globalEnv);
            if (results != null) {
                results.print(0);
            }else{
                System.out.printf("no values returned");
            }
            System.out.printf("\n");
            root = parser.parseExp();
        }
        System.exit(0);
    }

    public static void defineBuiltins(Environment env) {

        /**
         * specials
         * */
        Ident define = new Ident(Keywords.DEFINE);
        env.define(define,new Define());

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

        Ident binaryEquals = new Ident(Keywords.BINARY_EQUALS);
        env.define(binaryEquals, new BuiltInEquals(binaryEquals));

        Ident binaryLessThan = new Ident(Keywords.BINARY_LT);
        env.define(binaryLessThan, new BuiltInLessThan(binaryLessThan));


        /**type checks*/
        Ident isSymbol = new Ident(Keywords.SYMBOLCHECK);
        env.define(isSymbol,new BuiltInSymbolCheck(isSymbol));

        Ident isNumber = new Ident(Keywords.NUMBERCHECK);
        env.define(isNumber,new BuiltInNumberCheck(isNumber));

        /**list operations*/

        Ident car = new Ident(Keywords.CAR);
        env.define(car,new BuiltInCar(car));

        Ident cdr = new Ident(Keywords.CDR);
        env.define(cdr,new BuiltInCdr(cdr));


        Ident cons = new Ident(Keywords.CONS);
        env.define(cons,new BuiltInCons(cons));
        Ident quote = new Ident(Keywords.QUOTE);
        env.define(quote,new BuiltInCons(quote));



    }


}
