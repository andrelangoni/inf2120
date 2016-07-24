package bruno.test;

@SuppressWarnings("WeakerAccess")
public class ABR2<E extends Comparable<E>> {
  public E _element;
  public ABR2<E> _gauche;
  public ABR2<E> _droite;

  public ABR2(E element) {
    _element = element;
  } // ABR()

  public boolean estABR(ABR2<E> arbre) {
    boolean valide = true;

    if (arbre._droite != null) {
      if (arbre._droite._element.compareTo(arbre._element) < 0) {
        valide = false;
      } else {
        valide = estABR(arbre._droite);
      } // if
    } // if

    if (valide) {
      if (arbre._gauche != null) {
        if (arbre._gauche._element.compareTo(arbre._element) > 0) {
          valide = false;
        } else {
          valide = estABR(arbre._gauche);
        } // else
      } // if
    } // if

    return valide;
  } // estABR()
} // ABR2