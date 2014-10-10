package csc4101;

class Begin extends Special {
    private static final String text = "begin\n";

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void print(Node t, int n, boolean p){
        super.print(t, n, p);
        int newIndentation = n + Constants.INDENTATION;
        printSubsequent(t.cdr,newIndentation,p);

    }

    private void printSubsequent(Node t, int n, boolean p) {

        Node current = t;
        printIndentation(n);
        printCodeLine(t,n,p);

    }

    private void printCodeLine(Node t, int n, boolean p) {
        //while(!(t instanceof Nil)){
            t.print(n,p);
           // t = t.cdr;
        //}
    }


}
