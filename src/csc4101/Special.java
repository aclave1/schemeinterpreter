package csc4101;// Special.h -- the parse tree node data structure for special forms

import java.io.*;

// There are several different approaches for how to implement the Special
// hierarchy.  We'll discuss some of them in class.  The easiest solution
// is to not add any fields and to use empty constructors.

abstract class Special {

    private static final String _text = "$Special$";

    public Special(){

    }

    public void printIndentation(int n){
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }

    void print(Node t, int n, boolean p) {
        System.out.printf("%s",this.getText());
        Node cdr = t.getCdr();
        Node car = t.getCar();

        if(cdr != null){
            if(!(cdr instanceof Nil) && !(this instanceof Quote)) {
                System.out.printf(" ");
            }
            cdr.print(n,p);
        }

    }

    public abstract String getText();
}

