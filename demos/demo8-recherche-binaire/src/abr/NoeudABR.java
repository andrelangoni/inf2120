package abr;


/**
 * NoeudABR : Unité de base d'un arbre binaire de recherche.
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifié en Avril 2014
 */

public class NoeudABR<T> {

  private T element;            // référence vers l'élement stocké dans le noeud
  private NoeudABR<T> gauche;   // référence vers le noeud de gauche
  private NoeudABR<T> droit;    // référence vers le noeud de droite


  /**
   * Creation d'un objet NoeudABR avec l'élément.
   *
   * @param element reference vers l'objet qui sera stocké dans le noeud
   */
  public NoeudABR(T element) {
    this(element, null, null); // appel de l'autre constructeur
  }

  /**
   * Creation d'un objet NoeudABR  avec toutes les informations
   *
   * @param element reference vers l'objet qui sera stocké dans le noeud
   * @param gauche  reference vers le noeud de gauche
   * @param droit   reference vers le noeud de droite
   */
  public NoeudABR(T element, NoeudABR<T> gauche, NoeudABR<T> droit) {
    this.element = element;
    this.gauche = gauche;
    this.droit = droit;
  }

  /**
   * Creation d'un objet NoeudArbreBinaire à vide
   */
  public NoeudABR() {
    this(null, null, null); // appel du constructeur avec paramètres

  }

  /**
   * Obtenir la référence vers l'élément contenu dans le noeud.
   *
   * @return reference vers l'objet element
   */
  public T getElement() {
    return element;
  }

  /**
   * Permet d'initialiser ou modifier l'élément.
   *
   * @param element reference vers l'élément
   */
  public void setElement(T element) {
    this.element = element;
  }

  /**
   * Obtenir la référence vers le sous-arbre gauche.
   *
   * @return reference vers le sous-arbre droit
   */
  public NoeudABR<T> getGauche() {
    return gauche;
  }

  /**
   * Permet d'initialiser ou modifier le sous-arbre gauche.
   *
   * @param gauche reference vers le nouveau sous-arbre gauche.
   */
  public void setGauche(NoeudABR<T> gauche) {
    this.gauche = gauche;
  }

  /**
   * Obtenir la référence vers le sous-arbre droit.
   *
   * @return reference vers le sous-arbre droit
   */
  public NoeudABR<T> getDroit() {
    return droit;
  }

  /**
   * Permet d'initialiser ou modifier le sous-arbre droit.
   *
   * @param droit reference vers le nouveau sous-arbre droit
   */
  public void setDroit(NoeudABR<T> droit) {
    this.droit = droit;
  }


}
