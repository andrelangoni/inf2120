package question4;

public class Pile<E> {
  private int taille = 0;
  private Noeud<E> sommet = null; // pile vide

  public Pile() {
  }

  public int taille() {
    return taille;
  }

  public boolean estVide() {
    return sommet == null;
  }

  public E sommet() throws PileVide {
    if (estVide()) {
      throw new PileVide();
    } // if
    return sommet.element;
  } // tete()

  public void empiler(E a_element) {
    sommet = new Noeud<>(a_element, sommet);
    ++taille;
  } // empiler()

  public E depiler() throws PileVide {
    E element;

    if (estVide()) {
      throw new PileVide();
    } // if

    element = sommet.element;
    sommet = sommet.precedent;
    --taille;

    return element;
  } // defiler()

  @SuppressWarnings("TypeParameterHidesVisibleType")
  private class Noeud<E> { // private
    public E element;
    public Noeud<E> precedent;

    public Noeud(E element, Noeud<E> precedent) {
      this.element = element;
      this.precedent = precedent;
    }
  } // Noeud

  @Override
  public String toString() {
    String chaine = "";
    Noeud courant = sommet;

    for (int i = 0; i < taille; ++i) {
      chaine += courant.element + " ";
      courant = courant.precedent;
    }

    return chaine;
  }
} // Pile