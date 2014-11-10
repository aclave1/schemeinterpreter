public class BinaryOperation {


    public static NodePair extractBinaryArgs(Node args) {
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

    public static NodePair evaluateBinaryIntegerArgs(Node args, Environment env) throws InvalidArgumentException{
        NodePair pair = BinaryOperation.extractBinaryArgs(args);
        Node item1 = pair.item1.eval(pair.item1, env);
        Node item2 = pair.item2.eval(pair.item2, env);
        if (BinaryOperation.integerOperands(item1, item2)) {
            return new NodePair(item1,item2);
        } else {
            throw new InvalidArgumentException();
        }
    }


    /**
     * Applies the BinaryOperation op to a set of two integers.
     *
     * @param args a scheme list containing values to apply an operation to.
     * @param op   the operation to perform.
     * @return an IntLit representing the results of op.
     * @throws InvalidArgumentException
     */
    public static Node applyBinaryIntegerOperation(Node args, Environment env, BinaryArithmeticOperation op) throws InvalidArgumentException {
        NodePair pair = evaluateBinaryIntegerArgs(args,env);
        IntLit i1 = (IntLit) pair.item1;
        IntLit i2 = (IntLit) pair.item2;
        return new IntLit(op.operate(i1.getIntVal(),i2.getIntVal()));
    }

    public static Node applyBinaryIntegerOperation(Node args, Environment env, BinaryComparisonOperation op) throws InvalidArgumentException {
        NodePair pair = evaluateBinaryIntegerArgs(args, env);
        IntLit i1 = (IntLit) pair.item1;
        IntLit i2 = (IntLit) pair.item2;
        return new BooleanLit(op.operate(i1.getIntVal(),i2.getIntVal()));
    }


}
