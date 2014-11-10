class Ident extends Node {
    private String name;

    public Ident(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void print(int n) {
        System.out.printf("%s", name);
    }

    public boolean isSymbol(){return true;}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Node eval(Node node, Environment env) {
        Node retval = env.lookup(this);
        if(retval == null){
            try {
                throw new UndefinedVariableException();
            } catch (UndefinedVariableException e) {
                System.out.printf(InterpreterMessages.UNDEFINED_VAR,name);
                return new Nil();
            }
        }
        return retval;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object i){
        Ident z = (Ident) i;
        return this.getName().equals(z.getName());
    }
}
