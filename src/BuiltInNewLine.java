public class BuiltInNewLine extends BuiltIn{

    public BuiltInNewLine(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        return new StrLit("\n",true);
    }
}
