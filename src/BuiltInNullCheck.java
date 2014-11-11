public class BuiltInNullCheck extends BuiltIn {
    public BuiltInNullCheck(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node isNull = args.getCar();
        isNull = isNull.eval(isNull,env);
        return new BooleanLit(isNull.isNull());
    }
}
