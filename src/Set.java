class Set extends Special {

    @Override
    public String getText() {
        return Keywords.SET;
    }

    @Override
    public Node eval(Node node, Environment env) {
        Node key = node.getCdr().getCar();
        Node val = node.getCdr().getCdr().getCar();

        try {
            env.assign(key, val);
        } catch (UndefinedVariableException e) {
            return new Nil(String.format(InterpreterMessages.UNDEFINED_VAR_ASSIGNMENT_ERROR, key));
        }

        return new Nil();
    }
}
