package question7.application;

import question7.services.IPile;
import question7.services.PileVide;

public class Pile<T> implements IPile {
  private int _taille = 0;
  private Noeud<T> _sommet = null; // pile vide

  public Pile() {
  }

  public boolean estVide() {
    return _sommet == null;
  }

  public T tete() throws PileVide {
    if (estVide()) {
      throw new PileVide("La pile est vide");
    } // if
    return _sommet.element;
  } // tete()

  public void empiler(T element) {
    _sommet = new Noeud<T>(element, _sommet);
    ++_taille;
  } // empiler()

  public T depiler() throws PileVide {
    T temp = _sommet.element;
    if (estVide()) {
      throw new PileVide("La pile est vide");
    } // if
    _sommet = _sommet.precedent;
    --_taille;

    return temp;
  } // depiler()

  private class Noeud<E> { // private
    public E element;
    public Noeud<E> precedent;

    public Noeud(E element, Noeud<E> precedent) {
      this.element = element;
      this.precedent = precedent;
    }
  }

  /**
   * Retourne une nouvelle pile ayant les mêmes éléments mais en ordre inverse.
   *
   * @param p pile à copier
   */
  public static Pile copierInverse(Pile p) {
    Pile copie = new Pile();
    //Noeud<T> noeud = _sommet.precedent;
    while (!p.estVide()) {
      try {
        copie.empiler(p.depiler());
      } catch (PileVide pileVide) {
        pileVide.printStackTrace();
      }
    } // while()
    return copie;
  } // copierInverse()
} // Pile
