// Environment.java -- a data structure for Scheme environments

// An Environment is a list of frames.  Each frame represents a scope
// in the program and contains a set of name-value pairs.  The first
// frame in the environment represents the innermost scope.

// For the code below, I am assuming that a scope is implemented
// as an association list, i.e., a list of two-element lists.  E.g.,
// the association list ((x 1) (y 2)) associates the value 1 with x
// and the value 2 with y.

// To implement environments in an object-oriented style, it would
// be better to define a Frame class and make an Environment a list
// of such Frame objects.  If we simply use the parse tree structure
// for lists of association lists, we end up having to write the
// lookup functions in a more functional style.

// You need the following methods for modifying environments:
//  - constructors:
//      - create the empty environment (an environment with an empty frame)
//      - add an empty frame to the front of an existing environment
//  - lookup the value for a name (for implementing variable lookup)
//      if the name exists in the innermost scope, return the value
//      if it doesn't exist, look it up in the enclosing scope
//      if we don't find the name, it is an error
//  - define a name (for implementing define and parameter passing)
//      if the name already exists in the innermost scope, update the value
//      otherwise add a name-value pair as first element to the innermost scope
//  - assign to a name (for implementing set!)
//      if the name exists in the innermost scope, update the value
//      if it doesn't exist, perform the assignment in the enclosing scope
//      if we don't find the name, it is an error

import java.security.MessageDigest;

class Environment extends Node {

    // An Environment is implemented like a Cons node, in which
    // every list element (every frame) is an association list.
    // Instead of Nil(), we use null to terminate the list.

    private Frame scope;        // the innermost scope, an association list
    private Environment env;    // the enclosing environment

    public Environment() {
        this(null);
    }

    public Environment(Environment e) {
        scope = new Frame();
        env = e;
    }

    public void print(int n) {
        // there got to be a more efficient way to print n spaces
        PrettyPrintUtils.printIndentation(n);
        System.out.println("#{Environment");
        scope.print(n + 3);
        if (env != null) {
            env.print(n + 3);
        }
        PrettyPrintUtils.printIndentation(n);
        System.out.println('}');
    }


    public Node lookup(Node id) {
        Node val = scope.find(id);
        if (val == null && env == null) {
            System.out.println(DebugMessages.UNDEFINED_VARIABLE_LOOKUP_ERROR);
            return null;
        } else if (val == null) {
            // look up the identifier in the enclosing scope
            return env.lookup(id);
        } else {
            return val;
        }

    }


    /**
     * Defines a new variable in the current scope
     *
     * @param id
     * @param val
     */
    public void define(Node id, Node val) {
        scope.set(id, val);
    }

    /**
     * Sets the value of a variable, if it doesn't exist in the current scope, the enclosing scope is used recursively.
     *
     * @param id
     * @param val
     */
    public void assign(Node id, Node val) {
        Node exists = scope.find(id);
        if (exists != null) {
            scope.set(id, val);
        } else if (exists == null && env != null) {
            env.assign(id, val);
        } else {
            System.out.println(InterpreterMessages.UNDEFINED_VAR_ASSIGNMENT_ERROR);
        }
    }

    public Node eval(Node node, Environment env) {
        throw new Error(DebugMessages.CANNOT_EVAL);
    }
}
