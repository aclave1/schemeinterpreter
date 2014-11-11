
public class BuiltInInteractionEnvironment extends BuiltIn {
    public BuiltInInteractionEnvironment(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        return env.getGlobalEnv();
    }
}
