public class BuiltInSetCdr extends BuiltIn{
    public BuiltInSetCdr(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node cdrToSet = args.getCar();
        Node valToSet = args.getCdr().getCar();

        cdrToSet = cdrToSet.eval(cdrToSet,env);
        valToSet = valToSet.eval(valToSet,env);

        if(!cdrToSet.isPair()){
            return new Nil(String.format(InterpreterMessages.INVALID_SETCDR,cdrToSet));
        }
        cdrToSet.setCdr(valToSet);


        return new Nil("unspecified");


    }
}
