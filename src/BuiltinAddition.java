/**
 * Created by al on 11/4/14.
 */
public class BuiltinAddition extends BuiltIn {
    public BuiltinAddition(Node n) {
        super(n);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException{
        try {
            return applyAddition(args);
        } catch (InvalidArgumentException e) {
            System.out.printf("Attempted to add one or more non-integers");
            System.exit(0);
        }
        throw new InvalidApplyException();
    }

    private Node applyAddition(Node args) throws InvalidArgumentException {
        NodePair pair = BinaryOperation.extractBinaryArgs(args);
        if (integerOperands(pair.item1, pair.item2)) {
            IntLit item1 = (IntLit) pair.item1;
            IntLit item2 = (IntLit) pair.item2;
            return new IntLit(item1.getIntVal() + item2.getIntVal());
        }else{
            throw new InvalidArgumentException();
        }
    }

    private boolean integerOperands(Node arg1, Node arg2) {
        if (arg1.isNumber() && arg2.isNumber()) {
            return true;
        } else {
            return false;
        }
    }

}
