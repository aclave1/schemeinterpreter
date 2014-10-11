class BooleanLit extends Node {
    private boolean booleanVal;

    public BooleanLit(boolean b) {
        booleanVal = b;
    }

    public void print(int n) {
        if (booleanVal) {
            System.out.println("#t");
        } else {
            System.out.println("#f");
        }
    }

    @Override
    public String toString() {
        return booleanVal ? "#t" : "#f";
    }
}
