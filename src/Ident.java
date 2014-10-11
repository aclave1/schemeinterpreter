class Ident extends Node {
  private String name;

  public Ident(String n) { name = n; }

    public String getName(){
        return name;
    }
    public void print(int n) {
    System.out.printf("%s",name);
  }
    @Override
    public String toString(){
        return name;
    }
}
