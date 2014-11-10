import java.util.HashMap;

public class Frame {
    private HashMap<String, Node> scope;

    public Frame() {
        scope = new HashMap<>();
    }

    public Node find(Node id) {
        if (!(id instanceof Ident)) {
            throw new Error(InterpreterMessages.IDENT_LOOKUP_ERROR);
        }
        Ident ident = (Ident) id;
        return scope.get(ident.getName());
    }

    public void print(int n) {
        for (String key : scope.keySet()) {
            System.out.printf("(%s,", key);
            scope.get(key).print(n);
            System.out.printf(")");
        }
    }

    public void set(Node id, Node val) {
        try {
            scope.put(id.getName(), val);
        } catch (GetNameException g) {
            System.out.printf(DebugMessages.LITERAL_GETNAME_ERROR);
            System.exit(1);
        }
    }

}
