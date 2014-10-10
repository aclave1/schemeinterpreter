package csc4101;

/**
 * Created by al on 10/9/14.
 */
public class PrettyPrintUtils {
    public static void printIndentation(int n){

    }



    /***
     * Should this Special handle subsequent indentation?
     *
     * For example:
     * (begin <- handles subsequent indentation
     *      (+ 1 2)
     * )
     *
     * */
    public static boolean handlesIndentation(Special s){
        return (s instanceof Begin ||
                s instanceof If ||
                s instanceof Let ||
                s instanceof Cond ||
                s instanceof Lambda ||
                s instanceof Define
                );
    }


}
