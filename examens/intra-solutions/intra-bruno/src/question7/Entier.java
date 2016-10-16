package question7;

class Entier implements Comparable {
  private int nombre = 0;

  Entier(int nombre) {
    this.nombre = nombre;
  } // Entier()

  @Override
  public Ordre comparer(Comparable v2) {
    Ordre ordre = null;
    Entier entier2;

    if (v2 instanceof Entier) {
      entier2 = (Entier) v2;
      if (nombre == entier2.nombre) {
        ordre = Ordre.EGAL;
      } else if (nombre < entier2.nombre) {
        ordre = Ordre.PLUS_PETIT;
      } else {
        ordre = Ordre.PLUS_GRAND;
      } // else
    } // if

    return ordre;
  } // comparer()
} // Entier