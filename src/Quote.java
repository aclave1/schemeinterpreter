class Quote extends Special {

    @Override
    public String getText() {
        return Keywords.QUOTE;
    }

    @Override
    public Node eval(Node node, Environment env) {
        return node.getCdr().getCar();
    }
}
