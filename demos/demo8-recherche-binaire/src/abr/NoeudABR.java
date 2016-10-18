package abr;


/**
 * NoeudABR : Unit� de base d'un arbre binaire de recherche.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2008
 *          Modifi� en Avril 2014
 */

public class NoeudABR<T> {

  private T element;            // r�f�rence vers l'�lement stock� dans le noeud
  private NoeudABR<T> gauche;   // r�f�rence vers le noeud de gauche
  private NoeudABR<T> droit;    // r�f�rence vers le noeud de droite


  /**
   * Creation d'un objet NoeudABR avec l'�l�ment.
   *
   * @param element reference vers l'objet qui sera stock� dans le noeud
   */
  public NoeudABR(T element) {
    this(element, null, null); // appel de l'autre constructeur
  }

  /**
   * Creation d'un objet NoeudABR  avec toutes les informations
   *
   * @param element reference vers l'objet qui sera stock� dans le noeud
   * @param gauche  reference vers le noeud de gauche
   * @param droit   reference vers le noeud de droite
   */
  public NoeudABR(T element, NoeudABR<T> gauche, NoeudABR<T> droit) {
    this.element = element;
    this.gauche = gauche;
    this.droit = droit;
  }

  /**
   * Creation d'un objet NoeudArbreBinaire � vide
   */
  public NoeudABR() {
    this(null, null, null); // appel du constructeur avec param�tres

  }

  /**
   * Obtenir la r�f�rence vers l'�l�ment contenu dans le noeud.
   *
   * @return reference vers l'objet element
   */
  public T getElement() {
    return element;
  }

  /**
   * Permet d'initialiser ou modifier l'�l�ment.
   *
   * @param element reference vers l'�l�ment
   */
  public void setElement(T element) {
    this.element = element;
  }

  /**
   * Obtenir la r�f�rence vers le sous-arbre gauche.
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
   * Obtenir la r�f�rence vers le sous-arbre droit.
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
