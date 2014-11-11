public class BuiltInRead extends BuiltIn {
    public BuiltInRead(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
//        return args.eval(args,env).getCar();
        throw new Error("not implemented");
    }
}
