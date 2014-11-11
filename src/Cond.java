class Cond extends Special {

    @Override
    public String getText() {
        return Keywords.COND;
    }
    @Override
    public void print(Node t, int n, boolean p){
        super.print(t, n, p);
        int newIndentation = n + Constants.INDENTATION;
        PrettyPrintUtils.printSubsequentIndented(t.cdr,newIndentation,p);
    }
    @Override
    public Node eval(Node node, Environment env){
        //a condition and the return value

        Node cond = node.getCdr();

        Node statement = cond.getCar();



        while(statement != null && If.isFalse(statement.getCar(),env)){
            cond = cond.getCdr();
            statement = cond.getCar();
        }

        if(statement == null){
            return new Nil();
        }else{
            return statement.getCdr().eval(statement,env);
        }
    }
}
