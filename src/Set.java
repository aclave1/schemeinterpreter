class Set extends Special {

    private static final String text = "set!";
    @Override
    public String getText() {
        return text;
    }

    @Override
    public Node eval(Node node, Environment env){
        throw new Error("Not implemented");
    }
}
