public class BuiltInProcedureCheck extends BuiltIn {

    public BuiltInProcedureCheck(Node s) {
        super(s);
    }


    public Node apply(Node args, Environment env) throws InvalidApplyException {
        return args.getCar().eval(args, env).isProcedure() ? new BooleanLit(true) : new BooleanLit(false);
    }
}
