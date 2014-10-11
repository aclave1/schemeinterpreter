class Nil extends Node {
    public String rparen = ")";
    public String parens = "()";
  public Nil() { }

  public void print(int n)		{ print(n, false); }
  public void print(int n, boolean p) {
    if (p) {
      System.out.printf(rparen);
    } else {
      System.out.printf(parens);
    }
  }
    @Override
    public String toString(){
        return rparen;
    }
}