import java.util.Iterator;

class ListeDC<E> implements Iterable<E> {
  Noeud<E> debut = null;
  private Noeud<E> fin = null;
  private int taille = 0;

  ListeDC() {
  }

  boolean estVide() {
    return 0 == taille;
  }

  int taille() {
    return taille;
  }

  void ajouter_debut(E element) {
    Noeud<E> nouveau = new Noeud<>(element);

    if (null == fin) {
      fin = nouveau;
    } else {
      debut.precedent = nouveau;
    }

    nouveau.suivant = debut;
    debut = nouveau;

    ++taille;
  }

  void ajouter_fin(E element) {
    Noeud<E> nouveau = new Noeud<>(element);

    if (null == debut) {
      debut = nouveau;
    } else {
      fin.suivant = nouveau;
    }

    nouveau.precedent = fin;
    fin = nouveau;

    ++taille;
  }

  E debut() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    return debut.element;
  }

  E fin() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    return fin.element;
  }

  void supprimer_fin() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    fin = fin.precedent;

    if (null == fin) {
      debut = null;
    } else {
      fin.suivant = null;
    }

    --taille;
  }

  void supprimer_debut() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    debut = debut.suivant;

    if (null == debut) {
      fin = null;
    } else {
      debut.precedent = null;
    }

    --taille;
  }

  public Iterator<E> iterator() {
    return new IterListeDC<>(this);
  }
}