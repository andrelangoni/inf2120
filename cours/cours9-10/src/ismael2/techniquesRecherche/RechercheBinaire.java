package ismael2.techniquesRecherche;

import java.util.Arrays;


/**
 * RechercheBinaire.
 * <p>
 * Université du Québec à Montréal
 * <p>
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifié en Avril 2014
 */
public class RechercheBinaire<T extends Comparable<T>> {

  /**
   * Recherche binaire itérative dans un tableau ordonné en
   * ordre croissant.
   *
   * @param tableau          Tableau d'éléments
   * @param minIndice        L'indice minimum du tableau
   * @param maxIndice        L'indice maximum du tableau
   * @param valeurRecherchee Valeur recherchée
   * @return Indice de l'élément trouvé ou -1 si non trouvé
   */
  public int rechercheBinaireIterative(T[] tableau, int minIndice,
                                       int maxIndice, T valeurRecherchee) {

    int position = -1;

    while (minIndice <= maxIndice && position == -1) {

      int milieuIndice = (minIndice + maxIndice) / 2;
      System.out.print(tableau[milieuIndice] + ", ");

      if (tableau[milieuIndice].compareTo(valeurRecherchee) == 0) {
        position = milieuIndice;

      } else if (tableau[milieuIndice].compareTo(valeurRecherchee) > 0) {
        maxIndice = milieuIndice - 1;

      } else if (tableau[milieuIndice].compareTo(valeurRecherchee) < 0) {
        minIndice = milieuIndice + 1;
      }
    }

    return position;
  }

  /**
   * Recherche binaire recursive dans un tableau ordonné en
   * ordre croissant.
   *
   * @param tableau          Tableau d'éléments
   * @param minIndice        L'indice minimum du tableau
   * @param maxIndice        L'indice maximum du tableau
   * @param valeurRecherchee Valeur recherchée
   * @return Indice de l'élément trouvé ou -1 si non trouvé
   */
  public int rechercheBinaireRecursive(T tableau[], int minIndice,
                                       int maxIndice, T valeurRecherchee) {

    int indiceTrouve = -1;
    int milieuIndice = (minIndice + maxIndice) / 2;

    if (tableau[milieuIndice].compareTo(valeurRecherchee) == 0) {
      indiceTrouve = milieuIndice;

    } else if (tableau[milieuIndice].compareTo(valeurRecherchee) > 0) {
      if (minIndice <= milieuIndice - 1) {
        // Appel recursif avec la moitié gauche du tableau
        indiceTrouve = rechercheBinaireRecursive(tableau, minIndice,
            milieuIndice - 1, valeurRecherchee);
      }
    } else if (milieuIndice + 1 <= maxIndice) {
      // Appel recursif avec la moitié droite du tableau
      indiceTrouve = rechercheBinaireRecursive(tableau, milieuIndice + 1,
          maxIndice, valeurRecherchee);
    }

    return indiceTrouve;

  }


  @SuppressWarnings("unused")
  public static void main(String[] args) {

    Integer[] tableauDesordonne = {2, 5, 10, 4, 7, 1, 8, 3, 6, 9};
    Integer[] tableauOrdonne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    RechercheBinaire<Integer> rechercheBinaire = new RechercheBinaire<Integer>();

    System.out.print(Arrays.asList(tableauOrdonne));

    System.out.println();
    System.out.println();
    System.out.println("Recherche Binaire Iterative");
    System.out.println("Indice est " + rechercheBinaire.rechercheBinaireIterative(tableauOrdonne, 0, 9, 9));
    System.out.println("Recherche Binaire Recursive");
    System.out.println("Indice est " + rechercheBinaire.rechercheBinaireRecursive(tableauOrdonne, 0, 9, 9));
  }

}
