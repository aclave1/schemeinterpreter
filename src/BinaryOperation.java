/**
 * Operations applied to exactly 2 arguments
 */
public class BinaryOperation {


    public static NodePair extractBinaryArgs(Node args){
        NodePair pair = new NodePair();
        pair.item1 = args.getCar();
        pair.item2 = args.getCdr().getCar();
        return pair;
    }

    public static boolean integerOperands(Node arg1, Node arg2) {
        if (arg1.isNumber() && arg2.isNumber()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Applies the BinaryOperation op to a set of two integers.
     * @param args a scheme list containing values to apply an operation to.
     * @param op the operation to perform.
     * @return an IntLit representing the results of op.
     * @throws InvalidArgumentException
     */
    public static Node applyBinaryIntegerOperation(Node args, BinaryArithmeticOperation op) throws InvalidArgumentException{
        NodePair pair = BinaryOperation.extractBinaryArgs(args);
        if (BinaryOperation.integerOperands(pair.item1, pair.item2)) {
            IntLit item1 = (IntLit) pair.item1;
            IntLit item2 = (IntLit) pair.item2;
            return new IntLit(op.operate(item1.getIntVal(),item2.getIntVal()));
        }else{
            throw new InvalidArgumentException();
        }
    }

    public static Node applyBinaryIntegerOperation(Node args, BinaryComparisonOperation op) throws InvalidArgumentException{
        NodePair pair = BinaryOperation.extractBinaryArgs(args);
        if (BinaryOperation.integerOperands(pair.item1, pair.item2)) {
            IntLit item1 = (IntLit) pair.item1;
            IntLit item2 = (IntLit) pair.item2;
            return new BooleanLit(op.operate(item1.getIntVal(),item2.getIntVal()));
        }else{
            throw new InvalidArgumentException();
        }
    }



}
