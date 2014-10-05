package csc4101;

import java.io.InvalidClassException;

class Cons extends Node {
    private Node car;
    private Node cdr;
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
        if( name.equals("quote")){
            return new Quote();
        }else if(name.equals("lambda")){
            return new Lambda();
        }else if(name.equals("begin")){
            return new Begin();
        }else if(name.equals("if")){
            return new If();
        }else if(name.equals("let")){
            return new Let();
        }else if(name.equals("cond")){
            return new Cond();
        }else if(name.equals("define")){
            return new Define();
        }else if(name.equals("set!")){
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
        print(n,true);
    }

    void print(int n, boolean p) {
        boolean printRightParen = false;
        if(car instanceof Cons) {
            System.out.printf("(");
            printRightParen = true;
        }else{
            System.out.printf(" ");
        }
        form.print(this, n, p);

        if(cdr != null && !(cdr instanceof Nil)){
            cdr.print(n,p);
        }
        else if(cdr instanceof Nil && printRightParen){
            cdr.print(n,p);
        }

    }

}
