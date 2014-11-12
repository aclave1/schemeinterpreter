public class BuiltInAddition extends BuiltIn implements BinaryArithmeticOperation {
    public BuiltInAddition(Node n) {
        super(n);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException{
        try {
            return BinaryOperation.applyBinaryIntegerOperation(args,env,this);
        } catch (InvalidArgumentException e) {
            System.out.printf("Attempted to add one or more non-integers");
        }
        throw new InvalidApplyException();
    }

    public int operate(int val1,int val2){
        return val1+val2;
    }



}
