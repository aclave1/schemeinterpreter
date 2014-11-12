class Nil extends Node {
    public String lparen = "(";
    public String rparen = ")";
    public String parens = "(%s)";
    private boolean printOnlyright = false;
    private String _errorMessage = null;


    public Nil() {
    }

    public Nil(String errorMessage) {
        _errorMessage = errorMessage;
    }

    public Nil(boolean b) {
        printOnlyright = b;
    }

    public boolean isNull() {
        return true;
    }


    public void print(int n) {
        print(n, false);
    }

    public void print(int n, boolean p) {
        if (p || printOnlyright) {
            System.out.printf(rparen);
        } else {
            //prints error messages like {Undefined-var} and {Unspecified}
            if (_errorMessage != null) {
                System.out.printf(parens,_errorMessage);
            } else {
                System.out.printf(parens,"");
            }
        }
    }

    @Override
    public String toString() {
        return rparen;
    }

    @Override
    public Node eval(Node node, Environment env) {
        throw new Error(DebugMessages.CANNOT_EVAL);
    }
}
