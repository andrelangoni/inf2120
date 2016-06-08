package listeDC;

import listeDC.ListeDC;

public class Main {
    public static void main(String[] args) {
        ListeDC<Integer> listeDC = new ListeDC<>();
        listeDC.ajouter_debut(3);
        listeDC.ajouter_debut(2);
        listeDC.ajouter_debut(1);

        // iterable<Integer>
        for (Integer x : listeDC) {
            println(String.valueOf(x));
        } // for
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()

    public static void println(Object o) {
        System.out.println(o);
    } // println()
} // listeDC.Main
