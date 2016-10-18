class Noeud<T> {
  T element;
  Noeud<T> suivant;

  Noeud(T element, Noeud<T> suivant) {
    this.element = element;
    this.suivant = suivant;
  }
}