package typeGenerique;

public class Principale {
  public static void main(String[] args) {
    String bonjour = "bonjour";
    String allo = "allo";
    String salut = "salut";
    String bienvenu = "bienvenu";

    String[] tableau = {bonjour, allo, salut};

    test(tableau, salut);
    test(tableau, bienvenu);
  } // main()

  private static <T> void test(T[] tableau, T element) {
    PeutEtre<Integer> peutEtre = trouverElement(tableau, element);
    try {
      System.out.println("Indice de " + element + " = " + String.valueOf(peutEtre.qQChose()));
    } catch (ARien aRien) {
      System.out.println(element + " introuvable");
    } // catch
  } // test()

  private static <T> PeutEtre<Integer> trouverElement(T[] tableau, T element) {
    PeutEtre<Integer> peutEtre;
    boolean cherche = true;
    int i = 0;

    while (cherche && (i < tableau.length)) {
      // test avec equals equivaut a  == (egalite des adresses memoires)
      if (tableau[i].equals(element)) {
        cherche = false;
      } else {
        ++i;
      } // else
    } // while()

    if (cherche) {
      peutEtre = new Rien<>();
    } else {
      peutEtre = new QQChose<>(i);
    } // if

    return peutEtre;
  } // trouverElement()
} // Principale