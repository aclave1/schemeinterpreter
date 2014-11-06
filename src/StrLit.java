class StrLit extends Node {
    private String strVal;

    public StrLit(String s) {
        strVal = s;
    }

    public void print(int n) {
        System.out.printf("\"%s\"", strVal);
    }

    @Override
    public String toString() {
        return strVal;
    }

    @Override
    public Node eval(Node node, Environment env) {
        return this;
    }
}
