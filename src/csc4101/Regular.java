package csc4101;

import java.io.*;

class Regular extends Special {
    public Node node;

    public Regular(Node _node){
        node = _node;
    }

    void print(Node t, int n, boolean p) {
        Node tCdr = t.getCdr();

        printIndentation(n);

        node.print(n,p);

        if(tCdr == null)return;

        if(!(tCdr instanceof Nil)){
            System.out.printf(Keywords.SPACE);
        }
    }
    @Override
    public String getText() {
        return node.toString();
    }
}
