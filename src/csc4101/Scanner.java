package csc4101;// Scanner.java -- the implementation of class Scanner

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;

class Scanner {
    private PushbackInputStream in;
    private byte[] buf = new byte[1000];

    public Scanner(InputStream i) {
        in = new PushbackInputStream(i);
    }

    public Token getNextToken() {
        int bite;

        // It would be more efficient if we'd maintain our own input buffer
        // and read characters out of that buffer, but reading individual
        // characters from the input stream is easier.

        //
        bite = tryRead(in);

        if (bite == -1)
            return null;

        char ch = (char) bite;

        // Special characters
        if (ch == '\'')
            return new Token(Token.QUOTE);
        else if (ch == ' ') {
            return getNextToken();
        } else if (ch == '(')
            return new Token(Token.LPAREN);
        else if (ch == ')')
            return new Token(Token.RPAREN);
        else if (ch == '.')
            // We ignore the special identifier `...'.
            return new Token(Token.DOT);

            // Boolean constants
        else if (ch == '#') {
            try {
                bite = in.read();
            } catch (IOException e) {
                System.err.println("We fail: " + e.getMessage());
            }

            if (bite == -1) {
                System.err.println("Unexpected EOF following #");
                return null;
            }
            ch = (char) bite;
            if (ch == 't')
                return new Token(Token.TRUE);
            else if (ch == 'f')
                return new Token(Token.FALSE);
            else {
                System.err.println("Illegal character '" + (char) ch + "' following #");
                return getNextToken();
            }
        }

        // String constants
        //quote character ' " '
        else if (ch == '"') {
            // TODO: scan a string into the buffer variable buf
            return new StrToken(buf.toString());
        }

        // Integer constants
        else if (ch >= '0' && ch <= '9') {
            int i = ch - '0';
            // TODO: scan the number and convert it to an integer

            // put the character after the integer back into the input
            // in->putback(ch);
            return new IntToken(i);
        }

        // Operators: +, -, *, /
        else if (ch == '+' || ch == '-' || ch == '/' || ch == '*')
            return new IdentToken(Character.toString(ch));

            // Identifiers
        else if (isAlphabetic(ch)
         /* or ch is some other valid first character for an identifier */) {
            // TODO: scan an identifier into the buffer

            char c = (char) tryRead(in);

            while (c >= 'A' && c <= 'Z') {

            }

            // put the character after the identifier back into the input
            // in->putback(ch);
            return new IdentToken(buf.toString());
        }

        // Illegal character
        else {
            System.err.println("Illegal input character '" + (char) ch + '\'');
            return getNextToken();
        }
    }

    private int tryRead(PushbackInputStream str) {
        int b = -1;
        try {
            b = str.read();
        } catch (IOException e) {
            System.err.println("We fail: " + e.getMessage());
        }
        return b;
    }

    /**
     * @param ident a char[] representing a potential identifier
     * @return true if this char[] adheres to:
     *
        <identifier> --> <initial> <subsequent>*
             | <peculiar identifier>
        <initial> --> <letter> | <special initial>
        <letter> --> a | b | c | ... | z

        <special initial> --> ! | $ | % | & | * | / | : | < | =
             | > | ? | ^ | _ | ~
        <subsequent> --> <initial> | <digit>
             | <special subsequent>
        <digit> --> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
        <special subsequent> --> + | - | . | @
     *
     * **/
    private boolean isValidIdent(char[] ident) {
        if (!isValidInitial(ident[0])) return false;
        for (int i = 1; i < ident.length; i++) {
            if (!isValidSubsequent(ident[i])) return false;
        }
        return true;
    }

    private boolean isValidInitial(char c) {
        return (isAlphabetic(c) ||
                isSpecialInitial(c)
        );
    }

    private boolean isValidSubsequent(char c) {
        return (isValidInitial(c)  ||
                isNumber(c) ||
                isSpecialSubsequent(c));
    }

    /**
     * A-Z || a-z
     */
    private boolean isAlphabetic(char c) {
        //          uppercase alphabet     lowercase alphabet
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    /**
     * A special character which is valid in an identifier, but not at the beginning
     */
    private boolean isSpecialSubsequent(char c) {
        return (c == '.' ||
                c == '+' ||
                c == '-' ||
                c == '@');
    }

    /**
     * A special character which is valid at any part of an identifier
     */
    private boolean isSpecialInitial(char c) {
        return (c == '!' ||
                c == '|' ||
                c == '$' ||
                c == '|' ||
                c == '%' ||
                c == '|' ||
                c == '&' ||
                c == '|' ||
                c == '*' ||
                c == '|' ||
                c == '/' ||
                c == '|' ||
                c == ':' ||
                c == '|' ||
                c == '<' ||
                c == '=' ||
                c == '>' ||
                c == '|' ||
                c == '?' ||
                c == '|' ||
                c == '^' ||
                c == '|' ||
                c == '_' ||
                c == '|' ||
                c == '~');
    }

    private boolean isDelimiter(char c) {
        return (c == ' ' ||
                c == '(' ||
                c == ')' ||
                c == ';' ||
                isQuote(c)
        );
    }

    /**
     * A quotation mark. '"' looks confusing.
     */
    private boolean isQuote(char c) {
        return c == '"';
    }

}
