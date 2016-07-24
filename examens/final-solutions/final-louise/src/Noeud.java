public class Noeud<T> {
  private T info; // information dans le noeud
  private Noeud<T> gauche; // sous-arbre gauche
  private Noeud<T> droite; // sous-arbre droit

  /**
   * Cree un nouveau noeud feuille
   *
   * @param element l'information qui sera stockee dans le noeud
   */
  public Noeud(T element) {
    info = element;
  }

  /**
   * Cree un nouveau noeud ayant un autre noeud existant a gauche et un autre noeud
   * existant a droite
   *
   * @param element l'information qui sera stockee dans le noeud
   * @param gauche  le noeud qui sera le noeud a gauche du noeud cree
   * @param droite  le noeud qui sera le noeud a droite du noeud cree
   */
  public Noeud(T element, Noeud<T> gauche, Noeud<T> droite) {
    info = element;
    this.gauche = gauche;
    this.droite = droite;
  }

  public T info() {
    return info;
  }

  public Noeud<T> gauche() {
    return gauche;
  }

  public Noeud<T> droite() {
    return droite;
  }

  public void modifierInfo(T element) {
    info = element;
  }

  public void modifierGauche(Noeud<T> gauche) {
    this.gauche = gauche;
  }

  public void modifierDroite(Noeud<T> droite) {
    this.droite = droite;
  }
} // Noeud