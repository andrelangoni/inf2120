package typeGenerique;

public class Principale {
    public static void main(String[] args) {

    } // main()

    public static <T> PeutEtre<Integer> trouverElement(T[] tableau, T element) {
        PeutEtre<Integer> integerPeutEtre;

        boolean cherche = true;
        int i = 0;

        while (cherche && (i < tableau.length)) {
            // test avec l'adresse en memoire
            if (tableau[i] == element) {
                cherche = false;
            } // if

            ++i;
        } // while()

        if (cherche) {
            integerPeutEtre = new Rien<>();
        } else {
            integerPeutEtre = new QQChose<Integer>(i);
        } // if

        return integerPeutEtre;
    } // trouverElement()
} // Principale