class Begin extends Special {

    @Override
    public String getText() {
        return Keywords.BEGIN;
    }

    @Override
    public void print(Node t, int n, boolean p){
        super.print(t, n, p);
        int newIndentation = n + Constants.INDENTATION;
        PrettyPrintUtils.printSubsequentIndented(t.cdr,newIndentation,p);
    }
    @Override
    public Node eval(Node node, Environment env){
        return executeStatements(node,env);
    }

    public Node executeStatements(Node node, Environment env){
        Node statement = node.getCdr();
        Node nextStatement = statement;
        while(!nextStatement.isNull()){
            statement.getCar().eval(statement,env);
            statement = nextStatement;
            nextStatement = nextStatement.getCdr();
        }
        return statement.getCar().eval(statement,env);
    }
}
