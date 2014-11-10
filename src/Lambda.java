class Lambda extends Special {

    private static final String text = "lambda";

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
        return new Closure(node.getCdr(),env);
    }
}
