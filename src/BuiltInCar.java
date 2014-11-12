public class BuiltInCar extends BuiltIn {
    public BuiltInCar(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node getCarOf = args.getCar();
        Node car;
        if(getCarOf == null){
            System.out.printf(InterpreterMessages.INVALID_CAR);
            return new Nil();
        }
        getCarOf = getCarOf.eval(getCarOf,env);

        car = getCarOf.getCar();

        if(car == null){
            return new Nil();
        }
        return car;

    }



}
