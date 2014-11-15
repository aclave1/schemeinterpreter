public class BuiltInCdr extends BuiltIn{
    public BuiltInCdr(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node getCdrOf = args.getCar();

        if(getCdrOf == null){
            System.out.printf(InterpreterMessages.INVALID_CDR);
            return new Nil();
        }
        getCdrOf = getCdrOf.eval(getCdrOf,env);


        try {
            return getCdrOf.getCdr();
        } catch (NullPointerException e) {
            return new Nil(InterpreterMessages.INVALID_CDR);
        }

    }


}
