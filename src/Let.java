class Let extends Special {

    @Override
    public String getText() {
        return Keywords.LET;
    }

    @Override
    public void print(Node t, int n, boolean p) {
        super.print(t, n, p);
        int newIndentation = n + Constants.INDENTATION;
        PrettyPrintUtils.printSubsequentIndented(t.cdr, newIndentation, p);
    }

    @Override
    public Node eval(Node node, Environment env) {
        Node letList = node.getCdr().getCar();
        Node procedure = node.getCdr().getCdr();
        Environment letEnv = letEnvironment(letList, env);
        return Begin.executeExpressions(procedure, letEnv);
    }


    public Environment letEnvironment(Node letList, Environment env) {
        Environment letEnv = new Environment(env);
        Node var = letList.getCar();

        while (!letList.isNull()) {
            Node key = var.getCar();
            Node val = var.getCdr().getCar();
            val = val.eval(val, env);
            letEnv.define(key, val);
            letList = letList.getCdr();
            var = letList.getCar();
        }


        return letEnv;
    }

}
