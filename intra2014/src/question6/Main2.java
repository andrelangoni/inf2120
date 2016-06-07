package question6;

import question4.File;
import question4.FileVide;

public class Main2 {
    public static void main(String[] args) {

    } // main()

    /**
     * Inverse les elements de la file f donnee.
     * <p>
     * Vous ne pouvez utiliser que des variables locales de type primitif.
     *
     * @param f la file dont on veut inverser les elements.
     * @throws NullPointerException si f est null.
     */
    public static void inverser(File<Integer> f) throws FileVide {
        int i;
        if (f == null) {
            throw new NullPointerException();
        } else if (!f.estVide()) {
            i = f.defiler();
            inverser(f);
            f.enfiler(i); //au retour de la recursion, les elements sont enfiles dans l'ordre inverse.
        } // else if
        //cas de base : f est vide
    } // inverser()
} // Main