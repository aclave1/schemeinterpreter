package csc4101;

class If extends Special {
    private static final String text = "if";
    @Override
    public String getText() {
        return text;
    }

    @Override
    public void print(Node t, int n, boolean p){
        super.print(t,n,p);
        Node firstLine = t.cdr.car;
        firstLine.print(n,p);
        System.out.printf("\n");
        Node secondLine = t.cdr.cdr;
        n += Constants.INDENTATION;
        PrettyPrintUtils.printSubsequentIndented(secondLine,n,p);
    }

}
