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

        Node x = _node.eval(node, env);
        if (x.isProcedure()) {
            try {
                return x.apply(node.cdr, env);
            } catch (InvalidApplyException e) {
                System.out.printf(InterpreterMessages.NON_FUNCTION_APPLY);
                System.exit(1);
            }
        }
        return x;


    }

}
