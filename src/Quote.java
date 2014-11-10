class Quote extends Special {
    private static final String text = Keywords.QUOTE;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Node eval(Node node, Environment env) {
        return node.getCdr().getCar();
    }
}
