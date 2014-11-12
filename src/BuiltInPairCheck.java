public class BuiltInPairCheck extends BuiltIn {
    public BuiltInPairCheck(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node isPair = args.getCar();
        isPair = isPair.eval(isPair, env);
        return new BooleanLit(isPair.isPair());
    }
}
