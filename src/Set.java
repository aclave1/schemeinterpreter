class Set extends Special {

    @Override
    public String getText() {
        return Keywords.SET;
    }

    @Override
    public Node eval(Node node, Environment env){
        throw new Error("Not implemented");
    }
}
