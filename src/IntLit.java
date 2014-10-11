class IntLit extends Node {
  private int intVal;

  public IntLit(int i) { intVal = i; }

  public void print(int n) {
    System.out.printf("%d",intVal);
  }
    @Override
    public String toString(){
        return Integer.toString(intVal);
    }
}
