import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ExempleIterateur {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        } // for

        int somme = 0;

        for (int i = 0; i < list.size(); i++) {
            somme += list.get(i);
        } // for

        // Ce code est répétitf pour les classes ArrayList, Stack etc.
        // permet de réutiliser le code
        ListeDC<Integer> listeDC = new ListeDC<>();
        listeDC.ajouter_debut(7);
        listeDC.ajouter_debut(5);
        listeDC.ajouter_debut(3);

        Iterator<Integer> iterator = listeDC.iterator();
        while (iterator.hasNext()) {
            Integer x = iterator.next();
            System.out.println(x);
        } // while
    } // main()

    public static Integer somme(Iterable<Integer> iterable) {
        Integer somme = 0;
        for (Iterator<Integer> i = iterable.iterator();
                i.hasNext();) {
            somme += i.next();
        } // for

        return somme;
    } // somme()
} // ExempleIterateur
