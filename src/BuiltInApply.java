public class BuiltInApply extends BuiltIn{

    public BuiltInApply(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node node, Environment env) throws InvalidApplyException {

        Node fn = node.getCar();
        Node args = node.getCdr().getCar();
        if(fn == null || args == null){ return new Nil(InterpreterMessages.INVALID_ARITY);}
        fn = fn.eval(fn,env);
        args = args.eval(args,env);

        return fn.apply(args,env);

    }
}
