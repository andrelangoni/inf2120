import java.util.Iterator;

class ListeDC<E> implements Iterable<E> {
  Noeud<E> _debut = null;
  private Noeud<E> _fin = null;
  private int _taille = 0;

  ListeDC() {
  }

  boolean estVide() {
    return 0 == _taille;
  }

  int taille() {
    return _taille;
  }

  void ajouter_debut(E a_element) {
    Noeud<E> nouveau = new Noeud<>(a_element);

    if (null == _fin) {
      _fin = nouveau;
    } else {
      _debut.precedent = nouveau;
    }

    nouveau.suivant = _debut;
    _debut = nouveau;

    ++_taille;
  }

  void ajouter_fin(E a_element) {
    Noeud<E> nouveau = new Noeud<>(a_element);

    if (null == _debut) {
      _debut = nouveau;
    } else {
      _fin.suivant = nouveau;
    }

    nouveau.precedent = _fin;
    _fin = nouveau;

    ++_taille;
  }

  E debut() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    return _debut.element;
  }

  E fin() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    return _fin.element;
  }

  void supprimer_fin() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    _fin = _fin.precedent;

    if (null == _fin) {
      _debut = null;
    } else {
      _fin.suivant = null;
    }

    --_taille;
  }

  void supprimer_debut() throws EstVide {
    if (estVide()) {
      throw new EstVide();
    }

    _debut = _debut.suivant;

    if (null == _debut) {
      _fin = null;
    } else {
      _debut.precedent = null;
    }

    --_taille;
  }

  public Iterator<E> iterator() {
    return new IterListeDC<>(this);
  }
}