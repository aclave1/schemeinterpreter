class Set extends Special {

    @Override
    public String getText() {
        return Keywords.SET;
    }

    @Override
    public Node eval(Node node, Environment env) {
        try {
            env.assign(node.getCdr().getCar(),node.getCdr().getCdr().getCar());
        }catch(UndefinedVariableException e){

        }
        return new Nil();
    }
}
