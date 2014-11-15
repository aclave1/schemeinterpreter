public class BuiltInObjectEquals extends BuiltIn {

    public BuiltInObjectEquals(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        NodePair argPair = BinaryOperation.extractBinaryArgs(args,env);

        Node item1 = argPair.item1.eval(argPair.item1, env);
        Node item2 = argPair.item2.eval(argPair.item2, env);
        if (item1 == item2) {
            return new BooleanLit(true);
        } else if (item1 instanceof Nil && item2 instanceof Nil) {
            //in scheme48 '() == '()
            return new BooleanLit(true);
        } else {
            return new BooleanLit(false);
        }


    }
}
