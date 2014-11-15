public class BuiltInApply extends BuiltIn {

    public BuiltInApply(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        if (args.getCar() == null) return new Nil(InterpreterMessages.INVALID_ARITY);
        Node fn = args.getCar().eval(args.getCar(), env);
        if (args.getCdr() == null || args.getCdr().getCar() == null) return new Nil(InterpreterMessages.INVALID_ARITY);
        Node list = args.getCdr().getCar();
        list = list.eval(list, env);
        if (!fn.isProcedure()) return new Nil(InterpreterMessages.NON_FUNCTION_APPLY);

        return fn.apply(list, env);
    }
}
