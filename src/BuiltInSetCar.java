public class BuiltInSetCar extends BuiltIn{
    public BuiltInSetCar(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node carToSet = args.getCar();
        Node valToSet = args.getCdr().getCar();

        carToSet = carToSet.eval(carToSet,env);
        valToSet = valToSet.eval(valToSet,env);

        if(!carToSet.isPair()){
            return new Nil(String.format(InterpreterMessages.INVALID_SETCAR,carToSet));
        }
        carToSet.setCar(valToSet);


        return new Nil("unspecified");
    }
}
