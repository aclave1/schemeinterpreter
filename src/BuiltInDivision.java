public class BuiltInDivision extends BuiltIn implements BinaryArithmeticOperation {

    public BuiltInDivision(Node s) {
        super(s);
    }

    @Override
    public int operate(int arg1, int arg2) {
        if(arg2 == 0){
            throw new ArithmeticException("Division by zero");
        }
        return arg1 / arg2;
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        try {
            return BinaryOperation.applyBinaryIntegerOperation(args,env,this);
        } catch (InvalidArgumentException e) {
            System.out.printf(InterpreterMessages.NON_INTEGER_DIVISION);
            System.exit(1);
        }
        return null;
    }
}
