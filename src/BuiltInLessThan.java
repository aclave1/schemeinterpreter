public class BuiltInLessThan extends BuiltIn implements BinaryComparisonOperation {

    public BuiltInLessThan(Node s) {
        super(s);
    }

    @Override
    public boolean operate(int arg1, int arg2) {
        return arg1 < arg2;
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        try {
            return BinaryOperation.applyBinaryIntegerOperation(args,this);
        } catch (Exception e) {
            System.out.printf(InterpreterMessages.NON_INTEGER_LT);
        }
        return null;
    }
}
