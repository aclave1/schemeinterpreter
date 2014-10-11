package csc4101;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by al on 10/9/14.
 */
public class PrettyPrintUtils {
    public static void printIndentation(int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(Constants.SPACE);
        }

        /**
         * more efficient, but the space constant cannot be changed to another character for debugging.
         * System.out.printf("%"+n+"s","");
         */
    }

    public static void printSubsequentIndented(Node t, int n, boolean p) {

        if(t == null) return;
        while(t != null){
            if(t.car instanceof Cons){
                printIndentation(n);
                t.car.print(n,p);
                //printSubsequentIndented(t.car,n,p);
            }else if(t instanceof Nil){
                int newIndentation = n - Constants.INDENTATION;
                printIndentation(newIndentation);
                t.print(newIndentation,p);
            }else{
                printIndentation(n);
                if(t.car instanceof Nil){
                    t.car.print(n,false);
                }else{
                    t.car.print(n,p);
                }
            }
            System.out.printf("\n");
            t = t.cdr;
        }
    }

    public static void printFirstElementOnSameLine(Node t, int n, boolean p){
        Node firstLine = t.cdr.car;
        firstLine.print(n,p);
        System.out.printf("\n");
        Node secondLine = t.cdr.cdr;
        n += Constants.INDENTATION;
        printSubsequentIndented(secondLine,n,p);
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
