package question7;

@SuppressWarnings("WeakerAccess")
public class Couple<T extends Comparable> implements Comparable {
  private T a1;
  private T a2;

  public Couple(T v1, T v2) {
    a1 = v1;
    a2 = v2;
  } // Couple()

  /**
   * Deux couples sont comparés de la façon suivante :
   * Si la composante a1 du premier est PLUS_PETIT que la composante a1
   * du deuxième alors le résultat sera PLUS_PETIT.
   * Si la composante a1 du premier est PLUS_GRAND que la composante a1
   * du deuxième alors le résultat sera PLUS_GRAND.
   * Si la composante a1 du premier est EGAL à la composante a1 du
   * deuxième alors la méthode retourne le résultat de la comparaison
   * des composantes a2 des deux couples.
   * @param v2 Deuxième couple de la comparaison. ('this' étant le premier)*/
  @Override
  public Ordre comparer(Comparable v2) {
    Ordre ordre = null;
    Couple couple2;

    if (v2 instanceof Couple) {
      couple2 = (Couple) v2;
      if (a1.comparer(couple2.a1) == Ordre.EGAL) {
        ordre = a2.comparer(couple2.a2);
      } else {
        ordre = a1.comparer(couple2.a1);
      } // else
    } // if

    return ordre;
  } // comparer()
} // Couple