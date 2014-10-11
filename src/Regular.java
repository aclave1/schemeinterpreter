class Regular extends Special {
    public Node node;

    public Regular(Node _node){
        node = _node;
    }

    void print(Node t, int n, boolean p) {
        Node tCdr = t.getCdr();

        //printIndentation(n);

        node.print(n,p);

        if(tCdr == null)return;
        printSpaceAfter(tCdr);
//        tCdr.print(n,p);

    }
    @Override
    public String getText() {
        return node.toString();
    }
}
