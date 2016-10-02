class File<T> implements IFile<T> {
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
      fin.suivant = new Noeud<>(element, null);
      fin = fin.suivant;
    }
    ++taille;
  }

  @Override
  public void defiler() throws FileVide {
    if (estVide()) {
      throw new FileVide("La file est vide");
    }

    debut = debut.suivant;

    if (debut == null)
      fin = null;
    --taille;
  }

  @Override
  public T trouverElement(int position) {
    int posActuelle = 0; // position actuelle
    Noeud<T> maillonTemp = debut;

    if (position > 0) {
      while (maillonTemp != null) {
        posActuelle++;
        if (posActuelle == position) {
          return maillonTemp.element;
        } else {
          maillonTemp = maillonTemp.suivant;
        } // else
      } // while
    } // if

    return null;
  } // trouverElement()
} // File