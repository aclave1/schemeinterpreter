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

    @Override
    public String toString() {
        return booleanVal ? "#t" : "#f";
    }
}
