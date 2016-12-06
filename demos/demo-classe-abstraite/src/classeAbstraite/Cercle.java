package classeAbstraite;

class Cercle extends Forme2D {
  private double rayon;

  Cercle(double rayon) {
    setRayon(rayon);
  } // Cercle()

  private void setRayon(double rayon) {
    if (rayon >= 0) {
      this.rayon = rayon;
    } else {
      System.err.println("Erreur: rayon invalide");
    } // else
  } // setRayon()

  @Override
  double aire() {
    return Math.PI * Math.pow(rayon, 2);
  } // aire()
} // Cercle