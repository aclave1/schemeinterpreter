public class BuiltInCar extends BuiltIn {
    public BuiltInCar(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node car = args.getCar().getCdr().getCar().getCar();

        if(car == null || car instanceof Nil){
            System.out.printf(InterpreterMessages.INVALID_CAR);
            return new Nil();
        }

        return car;
    }



}
