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

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Node eval(Node node, Environment env) {
        return env.lookup(this);
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
