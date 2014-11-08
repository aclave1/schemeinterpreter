/**
 * Created by al on 11/7/14.
 */
public class BinaryOperation {


    public static NodePair extractBinaryArgs(Node args){
        NodePair pair = new NodePair();
        pair.item1 = args.getCar();
        pair.item2 = args.getCdr().getCar();
        return pair;
    }



}
