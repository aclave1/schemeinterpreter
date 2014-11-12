class Set extends Special {

    @Override
    public String getText() {
        return Keywords.SET;
    }

    @Override
    public Node eval(Node node, Environment env){
        try {
            env.set(node.getCdr().getCar(),node.getCdr().getCdr().getCar());
        }catch(Exception e){
            return new Nil("cannot set undefined variable");
        }
        return new Nil();
    }
}
