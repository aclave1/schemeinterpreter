public class BuiltInNumberCheck extends BuiltIn{

    public BuiltInNumberCheck(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        if(args.car.isNumber()){
            return new BooleanLit(true);
        }return new BooleanLit(false);
    }
}
