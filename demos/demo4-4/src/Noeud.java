class Noeud<T> {
  Noeud<T> precedent = null;
  Noeud<T> suivant = null;
  T element = null;

  Noeud(T element) {
    this.element = element;
  } // Noeud()
} // Noeud