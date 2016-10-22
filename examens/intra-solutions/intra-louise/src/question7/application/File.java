
package question7.application;

import question7.services.FileVide;
import question7.services.IFile;

public class File<T> implements IFile<T> {
  public class Noeud<T> {
    T element;
    Noeud<T> precedent;

    public Noeud(T element, Noeud<T> precedent) {
      this.element = element;
      this.precedent = precedent;
    }
  }

  int _taille;
  Noeud<T> _debut;
  Noeud<T> _fin;

  public File() {
    _taille = 0;
    _debut = _fin = null;
  }

  @Override
  public boolean estVide() {
    return _debut == null;
  }

  @Override
  public T tete() throws FileVide {
    if (estVide()) {
      throw new FileVide("La file est vide");
    }
    return _debut.element;
  }

  @Override
  public void enfiler(T element) {
    if (estVide()) {
      _fin = new Noeud(element, null);
      _debut = _fin;
    } else {
      _fin.precedent = new Noeud(element, null);
      _fin = _fin.precedent;
    }
    ++_taille;
  }

  @Override
  public T defiler() throws FileVide {
    T temp = _debut.element;

    if (estVide()) {
      throw new FileVide("La file est vide");
    }

    _debut = _debut.precedent;

    if (_debut == null)
      _fin = null;

    return temp;
  }

  @Override
  public T trouverElement(int position) {
    int temp = 0;
    Noeud<T> maillon_temp = _debut;

    if (position > 0) {
      while (maillon_temp != null) {
        temp++;
        if (temp == position) {
          return maillon_temp.element;
        } else {
          maillon_temp = maillon_temp.precedent;
        }
      }
    }

    return null;
  }
}
