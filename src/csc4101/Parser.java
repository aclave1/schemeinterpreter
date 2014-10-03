package csc4101;// Parser.java -- the implementation of class Parser
//
// Defines
//
//   class Parser;
//
// Parses the language
//
//   exp  ->  ( rest
//         |  #f
//         |  #t
//         |  ' exp
//         |  integer_constant
//         |  string_constant
//         |  identifier
//    rest -> )
//         |  exp+ [. exp] )
//
// and builds a parse tree.  Lists of the form (rest) are further
// `parsed' into regular lists and special forms in the constructor
// for the parse tree node class Cons.  See Cons.parseList() for
// more information.
//
// The parser is implemented as an LL(0) recursive descent parser.
// I.e., parseExp() expects that the first token of an exp has not
// been read yet.  If parseRest() reads the first token of an exp
// before calling parseExp(), that token must be put back so that
// it can be reread by parseExp() or an alternative version of
// parseExp() must be called.
//
// If EOF is reached (i.e., if the scanner returns a NULL) token,
// the parser returns a NULL tree.  In case of a parse error, the
// parser discards the offending token (which probably was a DOT
// or an RPAREN) and attempts to continue parsing with the next token.

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class Parser {
    private Scanner scanner;

    public Parser(Scanner s) {
        scanner = s;
    }

    public Node parseExp() {
        Token token = scanner.getNextToken();
        return parseExp(token);
    }

    public Node parseExp(Token token) {

        int tokenType = token.getType();

        if (tokenType == TokenType.LPAREN) {
            return parseRest();
        } else if (tokenType == TokenType.IDENT) {
            return new Ident(token.getName());
        } else if (tokenType == TokenType.INT) {
            return new IntLit(token.getIntVal());
        } else if (tokenType == TokenType.STRING) {
            return new StrLit(token.getStrVal());
        } else if (tokenType == TokenType.TRUE) {
            return new BooleanLit(true);
        } else if (tokenType == TokenType.FALSE) {
            return new BooleanLit(false);
        } else if (tokenType == TokenType.QUOTE) {
            return new Cons(new Ident("quote"),new Cons(parseExp(),new Nil()));
        }else{
            return null;
        }
    }

    protected Node parseRest() {

        Token token = scanner.getNextToken();
        int tokenType = token.getType();

        if(tokenType == TokenType.DOT){
            return new Cons(parseExp(),parseRest());
        }else if(tokenType == TokenType.RPAREN){
            return new Nil();
        }else{
            return new Cons(parseExp(token),parseRest());
        }
    }
};
