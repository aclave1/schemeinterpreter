public class BuiltInRead extends BuiltIn {
    public BuiltInRead(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Parser parser = Parser.buildParser();
        return parser.parseExp();
    }
}
