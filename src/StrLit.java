class StrLit extends Node {
    private String strVal;
    //show quotes when printed?
    private boolean noQuotes = false;
    public StrLit(String s) {
        this(s,false);
    }
    public StrLit(String s,boolean noquotes) {
        strVal = s;
        noQuotes = true;
    }


    public void print(int n) {
        if(noQuotes){
            System.out.printf("%s", strVal);
        }else{
            System.out.printf("\"%s\"", strVal);
        }
    }

    public boolean isString() {
        return true;
    }

    @Override
    public String toString() {
        return strVal;
    }

    @Override
    public Node eval(Node node, Environment env) {
        return this;
    }
}
