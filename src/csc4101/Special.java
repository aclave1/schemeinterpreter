package csc4101;// Special.h -- the parse tree node data structure for special forms

// There are several different approaches for how to implement the Special
// hierarchy.  We'll discuss some of them in class.  The easiest solution
// is to not add any fields and to use empty constructors.

abstract class Special {

    private static final String _text = "$Special$";
    public Node node;
    public Special() {
        node = null;
    }



    void print(Node t, int n, boolean p) {
        System.out.printf("%s", this.getText());
        Node cdr = t.getCdr();
        printSpaceAfter(cdr);
    }

    protected void printSpaceAfter(Node cdr) {

        if (

            (PrettyPrintUtils.handlesIndentation(this) && !printsFirstElOnSameLine(this)) ||
            (cdr == null) ||
            (cdr instanceof Nil) ||
            (this instanceof Quote)){
                return;
        }
        System.out.printf(Constants.SPACE);
    }

    private boolean printsFirstElOnSameLine(Special t){
        return (t instanceof If ||
                t instanceof Lambda ||
                t instanceof Define);
    }

    public abstract String getText();
}

