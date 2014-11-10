public class BuiltInSubtraction extends BuiltIn implements BinaryArithmeticOperation {

    public BuiltInSubtraction(Node symbol){
        super(symbol);
    }

    public Node apply(Node node, Environment env){
        try {
            return BinaryOperation.applyBinaryIntegerOperation(node,env, this);
        } catch (InvalidArgumentException e) {
            System.out.printf(InterpreterMessages.NON_INTEGER_SUBTRACTION);
            System.exit(0);
        }
        return null;
    }

    @Override
    public int operate(int arg1, int arg2) {
        return arg1-arg2;
    }
}
