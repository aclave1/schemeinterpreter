/**
 * Basically just allows us to return two Nodes from one method.
 */
public class NodePair {
    public NodePair(){
        item1 = new Nil();
        item2 = new Nil();
    }

    public NodePair(Node i1, Node i2){
        item1 = i1;
        item2 = i2;
    }

    public Node item1;
    public Node item2;
}
