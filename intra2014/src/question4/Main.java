package question4;

@SuppressWarnings("WeakerAccess")
public class Main {
    public static void main(String[] args) {

    } // main()

    //On suppose mot non null.
    public static boolean estPalindrome(String mot) {
        boolean estPal = true;
        int j;
        Pile<Character> p = new Pile<>();
        for (int i = 0 ; i < mot.length() ; i++) {
            p.empiler(mot.charAt(i));
        }
        j = 0;
        while (!p.estVide() && estPal) {
            try {
                if (p.depiler() != mot.charAt(j)) {
                    estPal = false;
                }
            } catch (PileVide pileVide) {
                pileVide.printStackTrace();
            }
            j++;
        }
        return estPal;
    } // estPalindrome()

    public static void supprimer(File<Integer> f, int valeur) throws FileVide {
        int element;
        for (int i = f.taille(); i > 0; i--) {
            element = f.defiler();
            if (element != valeur) {
                f.enfiler(element);
            } // if
        } // for
    } // supprimer()
} // Main