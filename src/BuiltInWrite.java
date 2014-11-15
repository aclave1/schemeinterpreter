public class BuiltInWrite extends BuiltIn{

    public BuiltInWrite(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node car = args.getCar();
        if(car == null){return new Nil(InterpreterMessages.INVALID_ARITY);}
        Node nodeToPrint = car.eval(car,env);
        nodeToPrint.print(0);
        return Nil.noPrint();
    }
}
