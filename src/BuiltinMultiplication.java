/**
 * Created by al on 11/9/14.
 */
public class BuiltinMultiplication extends BuiltIn implements BinaryArithmeticOperation {
    public BuiltinMultiplication(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node node, Environment env) {
        try {
            return BinaryOperation.applyBinaryIntegerOperation(node, this);
        } catch (InvalidArgumentException e) {
            System.out.printf(InterpreterMessages.NON_INTEGER_MULTIPLICATION);
            System.exit(0);
        }
        return null;
    }


    @Override
    public int operate(int arg1, int arg2) {
        return arg1 * arg2;
    }
}
