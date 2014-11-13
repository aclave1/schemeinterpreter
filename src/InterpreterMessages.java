/**
 * Created by al on 11/3/14.
 */
public class InterpreterMessages {

    public static final String INVALID_EOF = "Error:End of file reached prematurely.\n";
    public static final String UNDEFINED_VAR = "error:undefined variable %s";

    public static final String IDENT_PRIMITIVE_ERROR = "Error:Cannot use primitive as identifier.\n";
    public static final String UNDEFINED_VAR_ASSIGNMENT_ERROR = "Error: cannot set! undefined variable: %s";
    public static final String IDENT_LOOKUP_ERROR = "Error:Improper identifier\n";
    public static final String NON_FUNCTION_APPLY = "Error: non-operator in operator position. Attempted to call non-function as function.\n";

    public static final String NON_INTEGER_ADDITION = "Error:Attempted to add one or more non-integers\n";
    public static final String NON_INTEGER_SUBTRACTION = "Error:Attempted to subtract one or more non-integers\n";
    public static final String NON_INTEGER_MULTIPLICATION = "Error:Attempted to multiply one or more non-integers\n";
    public static final String NON_INTEGER_DIVISION = "Error:Attempted to divide one or more non-integers\n";


    public static final String NON_INTEGER_EQUALS= "Error:Attempted to check integer equality on one or more non-integers\n";
    public static final String NON_INTEGER_LT = "Error:Attempted comparison on one or more non-integers\n";


    public static final String INVALID_CAR = "Error:argument type is invalid for car. Expected pair";
    public static final String INVALID_CDR = "Error:argument type is invalid for cdr. Expected pair";


    public static final String UNDEFINED_SET = "Error:Cannot set undefined variable:%s" ;
    public static final String INVALID_SETCAR = "Error: Cannot set-car of %s";
    public static final String INVALID_SETCDR = "Error: Cannot set-cdr of %s";
    public static final String INVALID_ARITY = "Error:function call has improper arity";
}
