class Define extends Special {


    @Override
    public String getText() {
        return Keywords.DEFINE;
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
            Node def = node.getCdr();
        if(node.getCdr().getCar().isPair()){
            Node name = def.getCar().getCar();
            Node params = node.getCdr().getCar().getCdr();
            Node code = node.getCdr().getCdr();
            Node fnDef = new Cons(params,code);
            env.define(name,new Closure(fnDef,env));


            int dbg = 1;
            return new Nil("no values returned");
        }


        NodePair args = BinaryOperation.extractBinaryArgs(node.cdr,env);


        if (!args.item1.isSymbol()) {
            System.out.printf(InterpreterMessages.IDENT_LOOKUP_ERROR);
            return new Nil();
        }else{
            Node val = args.item2.eval(node, env);
            env.define(args.item1, val);
        }
        return new Nil("no values returned");
    }
}
