public class BuiltInSymbolCheck extends BuiltIn{
    public BuiltInSymbolCheck(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        if(args.eval(args,env).isSymbol()){
            return new BooleanLit(true);
        }return new BooleanLit(false);
    }
}
