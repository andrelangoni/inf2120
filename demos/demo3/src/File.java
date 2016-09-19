class File<T> implements IFile<T> {
  private class Noeud<A> {
    A element;
    Noeud<A> precedent;

    Noeud(A element, Noeud<A> precedent) {
      this.element = element;
      this.precedent = precedent;
    }
  }

  private int taille;
  private Noeud<T> debut;
  private Noeud<T> fin;

  File() {
    taille = 0;
    debut = fin = null;
  }

  @Override
  public int taille() {
    return taille;
  }

  @Override
  public boolean estVide() {
    return taille == 0;
  }

  @Override
  public T tete() throws FileVide {
    if (estVide()) {
      throw new FileVide("La file est vide");
    }
    return debut.element;
  }

  @Override
  public void enfiler(T element) {
    if (estVide()) {
      fin = new Noeud<>(element, null);
      debut = fin;
    } else {
      fin.precedent = new Noeud<>(element, null);
      fin = fin.precedent;
    }
    ++taille;
  }

  @Override
  public void defiler() throws FileVide {
    if (estVide()) {
      throw new FileVide("La file est vide");
    }

    debut = debut.precedent;

    if (debut == null)
      fin = null;
    --taille;
  }

  @Override
  public T trouverElement(int position) {
    int temp = 0;
    Noeud<T> maillonTemp = debut;

    if (position > 0) {
      while (maillonTemp != null) {
        temp++;
        if (temp == position) {
          return maillonTemp.element;
        } else {
          maillonTemp = maillonTemp.precedent;
        } // else
      } // while
    } // if

    return null;
  } // trouverElement()
} // File