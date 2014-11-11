class If extends Special {

    @Override
    public String getText() {
        return Keywords.IF;
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
     * @return true if the condition evaluates to anything but #f
     *
     */
    public static boolean notFalse(Node cond, Environment env){
        Node result = cond.eval(cond,env);
        if (result.isBoolean()) {
            BooleanLit boolVal = (BooleanLit) result;
            return boolVal.getBooleanVal();
        }return true;
    }

    public static boolean isFalse(Node cond, Environment env){
        return !notFalse(cond,env);
    }

}
