class BooleanLit extends Node {
    private boolean booleanVal;

    public BooleanLit(boolean b) {
        booleanVal = b;
    }

    public void print(int n) {
        if (booleanVal) {
            System.out.printf("#t");
        } else {
            System.out.printf("#f");
        }
    }
    public boolean isBoolean(){
        return true;
    }
    public boolean getBooleanVal(){
        return booleanVal;
    }

    @Override
    public String toString() {
        return booleanVal ? "#t" : "#f";
    }
    @Override
    public Node eval(Node node, Environment env) {
        return this;
    }
}
