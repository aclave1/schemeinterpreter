public class Else extends Special {

    @Override
    public String getText() {
        return Keywords.ELSE;
    }

    @Override
    public Node eval(Node node, Environment env) {
        Node elseReturn = node.getCdr().getCar();
        return elseReturn.eval(elseReturn,env);
    }

    @Override
    public void print(Node t, int n, boolean p) {
        super.print(t, n, p);
    }
}
