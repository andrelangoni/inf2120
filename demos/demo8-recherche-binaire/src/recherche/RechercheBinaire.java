package recherche;

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
public class RechercheBinaire implements IRechercheBinaire {
  private static final int DEFAUT = -1;

  /**
   * Recherche binaire itérative dans un tableau ordonné en
   * ordre croissant.
   *
   * @param liste          Tableau d'éléments
   * @param valeurRecherchee Valeur recherchée
   * @return Indice de l'élément trouvé ou -1 si non trouvé
   */
  public int rechercheBinaireIterative(String[] liste, String valeurRecherchee) {
    int minIndice = 0; // L'indice minimum du tableau
    int maxIndice = liste.length - 1; // L'indice maximum du tableau
    int position = DEFAUT;

    while (minIndice <= maxIndice && position == -1) {
      int milieuIndice = (minIndice + maxIndice) / 2;
      System.out.print(liste[milieuIndice] + ", ");

      if (liste[milieuIndice].compareTo(valeurRecherchee) == 0) {
        position = milieuIndice;
      } else if (liste[milieuIndice].compareTo(valeurRecherchee) > 0) {
        maxIndice = milieuIndice - 1;
      } else if (liste[milieuIndice].compareTo(valeurRecherchee) < 0) {
        minIndice = milieuIndice + 1;
      } // else if
    } // while

    return position;
  } // rechercheBinaireIterative()

  /**
   * Recherche binaire recursive dans un tableau ordonné en
   * ordre croissant.
   *
   * @param liste          Tableau d'éléments
   * @param depart        L'indice minimum du tableau
   * @param fin        L'indice maximum du tableau
   * @param valeurRecherchee Valeur recherchée
   * @return Indice de l'élément trouvé ou -1 si non trouvé
   */
  public int rechercheBinaireRecursive(String[] liste, String valeurRecherchee, int depart, int fin)
      throws RechercheBinaireException {
    int indiceTrouve = DEFAUT;
    int milieuIndice = (depart + fin) / 2;

    if (liste[milieuIndice].compareTo(valeurRecherchee) == 0) {
      indiceTrouve = milieuIndice;
    } else if (liste[milieuIndice].compareTo(valeurRecherchee) > 0) {
      if (depart <= milieuIndice - 1) {
        // Appel recursif avec la moitié gauche du tableau
        indiceTrouve = rechercheBinaireRecursive(liste, valeurRecherchee, depart,
            milieuIndice - 1);
      } // if
    } else if (milieuIndice + 1 <= fin) {
      // Appel recursif avec la moitié droite du tableau
      indiceTrouve = rechercheBinaireRecursive(liste, valeurRecherchee, milieuIndice + 1,
          fin);
    } // else if

    if (indiceTrouve == DEFAUT) {
      throw new RechercheBinaireException();
    } // if

    return indiceTrouve;
  } // rechercheBinaireRecursive()

  public static void main(String[] args) {
    String[] tableauOrdonne = {"balle", "bleu", "couche", "goupille", "lune", "manchot", "nappe","oignon","serpent", "tarte"};
    RechercheBinaire rechercheBinaire = new RechercheBinaire();

    System.out.print(Arrays.asList(tableauOrdonne));
    System.out.println();
    System.out.println();

    System.out.println("Recherche Binaire Iterative pour \"lune\"");
    System.out.println("Indice est " + rechercheBinaire.rechercheBinaireIterative(tableauOrdonne, "lune"));

    System.out.println("Recherche Binaire Recursive pour \"couche\"");
    try {
      System.out.println("Indice est " + rechercheBinaire.rechercheBinaireRecursive(tableauOrdonne, "couche", 0, tableauOrdonne.length));
    } catch (RechercheBinaireException e) {
      e.printStackTrace();
    } // try
  } // main()

} // RechercheBinaire