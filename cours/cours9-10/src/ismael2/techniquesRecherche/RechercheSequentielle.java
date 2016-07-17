package ismael2.techniquesRecherche;


/**
 * RechercheSequentielle.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * <p>
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifi� en Avril 2014
 */
public class RechercheSequentielle<T extends Comparable<T>> {

  /**
   * Recherche s�quentielle dans un tableau non ordonn�.
   *
   * @param tableau          Tableau d'�l�ments
   * @param valeurRecherchee Valeur recherch�e
   * @return Positon de l'�l�ment recherch� ou -1 si non trouv�
   */
  public int rechercheSeqNonOrdonnee(T tableau[], T valeurRecherchee) {

    int position = -1;
    for (int i = 0; i < tableau.length && position == -1; i++) {
      if (tableau[i].compareTo(valeurRecherchee) == 0) {
        position = i;
      }

    }

    return position;
  }

  /**
   * Recherche s�quentielle dans un tableau ordonn�.
   *
   * @param tableau          Tableau d'�l�ments
   * @param valeurRecherchee Valeur recherch�e
   * @return Positon de l'�l�ment recherch� ou -1 si non trouv�
   */
  public int rechercheSeqOrdonnee(T tableau[], T valeurRecherchee) {

    int position = -1;
    boolean existePas = false;

    for (int i = 0; i < tableau.length && position == -1 && !existePas; i++) {
      if (tableau[i].compareTo(valeurRecherchee) == 0) {
        position = i;
      } else if (tableau[i].compareTo(valeurRecherchee) > 0) {
        existePas = true;
      }

    }

    return position;
  }


}
