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
        return notFalse(condition,env) ? ifTrue.eval(ifTrue,env) : ifFalse.eval(ifFalse,env);
    }

    /**
     *
     * @return
     */
    public static boolean notFalse(Node cond, Environment env){
        Node result = cond.eval(cond,env);
        if (result.isBoolean()) {
            BooleanLit boolVal = (BooleanLit) result;
            return boolVal.getBooleanVal();
        }return true;
    }

}
