public class Dot extends Cons{

    public Dot(Node a, Node d) {
        super(a, d);
    }
    public boolean isDot(){
        return true;
    }
    @Override
    public Node eval(Node node, Environment env) {
        return super.eval(node,env);
    }
}
