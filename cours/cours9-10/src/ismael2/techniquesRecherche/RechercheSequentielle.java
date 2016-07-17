package ismael2.techniquesRecherche;


/**
 * RechercheSequentielle.
 * <p>
 * Université du Québec à Montréal
 * <p>
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifié en Avril 2014
 */
public class RechercheSequentielle<T extends Comparable<T>> {

  /**
   * Recherche séquentielle dans un tableau non ordonné.
   *
   * @param tableau          Tableau d'éléments
   * @param valeurRecherchee Valeur recherchée
   * @return Positon de l'élément recherché ou -1 si non trouvé
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
   * Recherche séquentielle dans un tableau ordonné.
   *
   * @param tableau          Tableau d'éléments
   * @param valeurRecherchee Valeur recherchée
   * @return Positon de l'élément recherché ou -1 si non trouvé
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
