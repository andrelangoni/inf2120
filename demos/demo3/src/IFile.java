interface IFile<T> {
  int taille();

  boolean estVide();

  T tete() throws FileVide;

  void enfiler(T element);

  void defiler() throws FileVide;

  T trouverElement(int position);
}
