class Define extends Special {
    private static final String text = "define";

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void print(Node t, int n, boolean p) {
        super.print(t, n, p);
        if (isFunctionDefinition(t.cdr)) {
            t.cdr.car.print(n, p);
            System.out.printf("\n");
            int newIndentation = n + Constants.INDENTATION;
            PrettyPrintUtils.printSubsequentIndented(t.cdr.cdr, newIndentation, p);
        } else {
            t.cdr.print(n, p);
        }

    }


    public boolean isFunctionDefinition(Node t) {
        return (t.car instanceof Cons && t.car.car instanceof Ident);
    }


    @Override
    public Node eval(Node node, Environment env){
        NodePair args = BinaryOperation.extractBinaryArgs(node.cdr);
        if (!args.item1.isSymbol()) {
            System.out.printf(InterpreterMessages.IDENT_LOOKUP_ERROR);
            return new Nil();
        }
        Node val = args.item2.eval(node, env);
        env.define(args.item1, val);
        return new Nil();
    }
}
