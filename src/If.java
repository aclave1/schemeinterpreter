class If extends Special {
    private static final String text = "if";
    @Override
    public String getText() {
        return text;
    }

    @Override
    public void print(Node t, int n, boolean p){
        super.print(t,n,p);
        PrettyPrintUtils.printFirstElementOnSameLine(t,n,p);
    }
    @Override
    public Node eval(Node node, Environment env){
        Node condition = node.getCdr().getCar();

        Node ifTrue = node.getCdr().getCdr().getCar();
        Node ifFalse = node.getCdr().getCdr().getCdr().getCar();

        Node result = condition.eval(condition,env);

        if (result.isBoolean()) {
            BooleanLit boolVal = (BooleanLit) result;
            boolean val = boolVal.getBooleanVal();

            Node retval = val == true ? ifTrue.eval(ifTrue,env) : ifFalse.eval(ifFalse,env);

            return  retval;
        }
        return ifTrue.eval(ifTrue, env);


    }

}
