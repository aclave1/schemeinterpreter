package csc4101;

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
    void parseList() {
    }

    void parseList(Node n){

    }

    // TODO: Add any helper functions for parseList as appropriate.
    private Special parseSpecial(Node n){
        if(!( n instanceof Ident)) return null;

        Ident i = (Ident)n;
        String name = i.getName();
        if( name == "quote"){
            return new Quote();
        }else if(name == "lambda"){
            return new Lambda();
        }else if(name == "begin"){
            return new Begin();
        }else if(name == "if"){
            return new If();
        }else if(name == "let"){
            return new Let();
        }else if(name == "cond"){
            return new Cond();
        }else if(name == "define"){
            return new Define();
        }else if(name == "set!"){
            return new Set();
        }else{
            return null;
        }

    }
    private boolean isRegular(Node n){
        return (n instanceof IntLit ||
                n instanceof StrLit ||
                n instanceof BooleanLit);
    }



    public Cons(Node a, Node d) {
        car = a;
        cdr = d;
        parseList();
    }

    void print(int n) {
        form.print(this, n, false);
    }

    void print(int n, boolean p) {
        form.print(this, n, p);
    }

}
