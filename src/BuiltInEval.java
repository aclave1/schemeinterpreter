public class BuiltInEval extends BuiltIn {
    public BuiltInEval(Ident eval) {
        super(eval);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {

        NodePair argPair = BinaryOperation.extractBinaryArgs(args,env);

        Node envArg = argPair.item2.eval(argPair.item2, env);
        if (!(envArg instanceof Environment)) {
            throw new InvalidApplyException("Eval requires an environment as second argument.");
        }

        Environment newEnv = (Environment) envArg;
        Node toEval = argPair.item1.eval(argPair.item1, env);
        return toEval.eval(toEval, newEnv);

    }
}
