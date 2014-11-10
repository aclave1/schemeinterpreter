public class BuiltInCdr extends BuiltIn{
    public BuiltInCdr(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node cdr = args.getCar().getCdr().getCar().getCdr();

        if(cdr == null || cdr instanceof Nil){
            System.out.printf(InterpreterMessages.INVALID_CDR);
            return new Nil();
        }

        return cdr;
    }


}
