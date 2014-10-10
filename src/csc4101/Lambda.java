package csc4101;

import java.io.*;

class Lambda extends Special {

    private static final String text = "lambda";

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
