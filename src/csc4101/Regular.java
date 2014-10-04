package csc4101;

import java.io.*;

class Regular extends Special {
    private Node node;

    public Regular(Node _node){
        node = _node;

    }
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.

    void print(Node t, int n, boolean p) {
        printIndentation(n);
        t.print(n,p);
    }
}
