public class BuiltInEquals extends BuiltIn implements BinaryComparisonOperation {

    public BuiltInEquals(Node s) {
        super(s);
    }

    @Override
    public boolean operate(int arg1, int arg2) {
        return arg1 == arg2;
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        try {
            return BinaryOperation.applyBinaryIntegerOperation(args,env,this);
        } catch (Exception e) {
            System.out.printf(InterpreterMessages.NON_INTEGER_EQUALS);
        }
        return null;
    }
}
