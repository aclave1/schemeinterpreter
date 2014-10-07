package csc4101;

import java.io.InvalidClassException;

class Cons extends Node {
    private Special form;

    // parseList() `parses' special forms, constructs an appropriate
    // object of a subclass of Special, and stores a pointer to that
    // object in variable form.  It would be possible to fully parse
    // special forms at this point.  Since this causes complications
    // when using (incorrect) programs as data, it is easiest to let
    // parseList only look at the car for selecting the appropriate
    // object from the Special hierarchy and to leave the rest of
    // parsing up to the interpreter.
    void parseList(Node n){
        if(isRegular(n)){
            form = new Regular(n);
        }else{
            form = parseSpecial(n);
        }
    }

    private Special parseSpecial(Node n) {
        Ident i = (Ident)n;
        String name = i.getName();
        if( name.equals(Keywords.QUOTE)){
            return new Quote();
        }else if(name.equals(Keywords.LAMBDA)){
            return new Lambda();
        }else if(name.equals(Keywords.BEGIN)){
            return new Begin();
        }else if(name.equals(Keywords.IF)){
            return new If();
        }else if(name.equals(Keywords.LET)){
            return new Let();
        }else if(name.equals(Keywords.COND)){
            return new Cond();
        }else if(name.equals(Keywords.DEFINE)){
            return new Define();
        }else if(name.equals(Keywords.SET)){
            return new Set();
        }else{
            return new Regular(n);
        }
    }

    /**
     * Is regular and not an Ident
     * */
    private boolean isRegular(Node n){
        return (n instanceof IntLit ||
                n instanceof StrLit ||
                n instanceof BooleanLit ||
                n instanceof Nil ||
                n instanceof Cons
        );
    }


    public Cons(Node a, Node d) {
        car = a;
        cdr = d;
        parseList(car);
    }

    void print(int n) {
        print(n,false);
    }

    void print(int n, boolean p) {
        boolean printRightParen = p;
        //start of a list
        if(this.car instanceof Cons) {
            System.out.printf("(");
            form.print(this, n, true);
        }//empty list
        else if(this.car instanceof Nil){
            form.print(this,n,false);
        }//regular
        else{
            form.print(this, n, printRightParen);
        }

        //regular cdr
        if(this.cdr != null && !(cdr instanceof Nil)){
            this.cdr.print(n,printRightParen);
        }//end of a list
        else if(this.cdr instanceof Nil && printRightParen){
            this.cdr.print(n,printRightParen);
        }



    }

}
