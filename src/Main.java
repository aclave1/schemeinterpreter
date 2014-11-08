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

        IntLit x = new IntLit(1);
        IntLit y = new IntLit(1);





        // Parse and pretty-print each input expression
        Node root = parser.parseExp();
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
        Ident binaryPlus = new Ident(Keywords.BINARY_PLUS);
        env.define(binaryPlus, new BuiltinAddition(binaryPlus));

        Ident binaryMinus = new Ident(Keywords.BINARY_MINUS);
        env.define(binaryMinus, new BuiltInSubtraction(binaryMinus));


        //TODO: add builtins as we go

    }


}
