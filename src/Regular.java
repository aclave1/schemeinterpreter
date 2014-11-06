class Regular extends Special {
    public Node _node;

    public Regular(Node node) {
        _node = node;
    }

    void print(Node t, int n, boolean p) {
        Node tCdr = t.getCdr();
        _node.print(n, p);
        if (tCdr == null) return;
        printSpaceAfter(tCdr);
    }

    @Override
    public String getText() {
        return _node.toString();
    }

    @Override
    public Node eval(Node node, Environment env) {
        return _node.eval(node, env);
    }

}
