package recherche;

import java.util.Arrays;

/**
 * RechercheBinaire.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * <p>
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifi� en Avril 2014
 */
public class RechercheBinaire implements IRechercheBinaire {
  private static final int DEFAUT = -1;

  /**
   * Recherche binaire it�rative dans un tableau ordonn� en
   * ordre croissant.
   *
   * @param liste          Tableau d'�l�ments
   * @param valeurRecherchee Valeur recherch�e
   * @return Indice de l'�l�ment trouv� ou -1 si non trouv�
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
   * Recherche binaire recursive dans un tableau ordonn� en
   * ordre croissant.
   *
   * @param liste          Tableau d'�l�ments
   * @param depart        L'indice minimum du tableau
   * @param fin        L'indice maximum du tableau
   * @param valeurRecherchee Valeur recherch�e
   * @return Indice de l'�l�ment trouv� ou -1 si non trouv�
   */
  public int rechercheBinaireRecursive(String[] liste, String valeurRecherchee, int depart, int fin)
      throws RechercheBinaireException {
    int indiceTrouve = DEFAUT;
    int milieuIndice = (depart + fin) / 2;

    if (liste[milieuIndice].compareTo(valeurRecherchee) == 0) {
      indiceTrouve = milieuIndice;
    } else if (liste[milieuIndice].compareTo(valeurRecherchee) > 0) {
      if (depart <= milieuIndice - 1) {
        // Appel recursif avec la moiti� gauche du tableau
        indiceTrouve = rechercheBinaireRecursive(liste, valeurRecherchee, depart,
            milieuIndice - 1);
      } // if
    } else if (milieuIndice + 1 <= fin) {
      // Appel recursif avec la moiti� droite du tableau
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