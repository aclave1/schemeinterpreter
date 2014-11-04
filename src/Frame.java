import java.util.Hashtable;

/**
 * Created by al on 10/30/14.
 */
public class Frame {
    private Hashtable<Node, Node> scope;
    public Frame() {
        scope = new Hashtable<Node, Node>();
    }

    public Node find(Node id) {
        return scope.get(id);
    }

    public void print(int n) {
        try {
            for (Node key : scope.keySet()) {
                System.out.printf("(%s,", key.getName());
                scope.get(key).print(n);
                System.out.printf(")");
            }
        } catch (GetNameException g) {
            System.out.printf(DebugMessages.LITERAL_GETNAME_ERROR);
            System.exit(1);
        }
    }

    public void set(Node id, Node val){
        scope.put(id,val);
    }

}
