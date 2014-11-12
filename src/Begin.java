class Begin extends Special {

    @Override
    public String getText() {
        return Keywords.BEGIN;
    }

    @Override
    public void print(Node t, int n, boolean p) {
        super.print(t, n, p);
        int newIndentation = n + Constants.INDENTATION;
        PrettyPrintUtils.printSubsequentIndented(t.cdr, newIndentation, p);
    }

    @Override
    public Node eval(Node node, Environment env) {
        return executeExpressions(node, env);
    }

    /**
     * Executes a sequence of expressions
     *
     * @param node the node holding the list of expressions
     * @param env  the environment to execute the expressions in
     * @return the result of the last expression
     */
    public static Node executeExpressions(Node node, Environment env) {
        Node statement = node;
        Node nextStatement = statement.getCdr();


        while (!nextStatement.isNull()) {
            statement.getCar().eval(statement, env);
            statement = nextStatement;
            nextStatement = nextStatement.getCdr();
        }
        return statement.getCar().eval(statement, env);
    }
}
