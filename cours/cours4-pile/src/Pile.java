class Pile<E> {
  private int taille = 0; // pile vide au depart
  private Noeud<E> sommet = null;

  Pile() {
  }

  int taille() {
    return taille;
  }

  boolean estVide() {
    return sommet == null;
  }

  E sommet() throws PileVide {
    if (estVide()) {
      throw new PileVide();
    } // if

    return sommet.element;
  } // tete()

  void empiler(E a_element) {
    sommet = new Noeud<>(a_element, sommet);
    ++taille;
  } // enfiler()

  void depiler() throws PileVide {
    if (estVide()) {
      throw new PileVide();
    } // if
    sommet = sommet.precedent;
    --taille;
  } // defiler()

  private class Noeud<A> {
    private A element;
    private Noeud<A> precedent;

    private Noeud(A element, Noeud<A> precedent) {
      this.element = element;
      this.precedent = precedent;
    } // Noeud()
  } // Noeud
} // Pile