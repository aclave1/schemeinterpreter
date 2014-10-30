class Regular extends Special {
    public Node node;

    public Regular(Node _node){
        node = _node;
    }

    void print(Node t, int n, boolean p) {
        Node tCdr = t.getCdr();
        node.print(n,p);
        if(tCdr == null)return;
        printSpaceAfter(tCdr);
    }
    @Override
    public String getText() {
        return node.toString();
    }
}
