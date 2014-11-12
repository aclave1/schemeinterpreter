public class BuiltInCons extends BuiltIn {

    public BuiltInCons(Node s) {
        super(s);
    }

    @Override
    public Node apply(Node args, Environment env) throws InvalidApplyException {
        Node car = args.getCar();
        Node cdr = args.getCdr().getCar();

        car = car.eval(car, env);
        cdr = cdr.eval(cdr, env);
        Node n;
        if (cdr instanceof Cons) {
            n = new Cons(car, copyList(cdr), true);
        } else {
            n = new Cons(car, new Cons(cdr, new Nil()), true);
        }
        return n;

    }

    public Node copyList(Node list) {
        if (list instanceof Cons) {
            return new Cons(list.getCar(), copyList(list.getCdr()));
        } else if (list instanceof Nil) {
            return list;
        }
        return new Cons(list, new Nil(false));

    }


}
