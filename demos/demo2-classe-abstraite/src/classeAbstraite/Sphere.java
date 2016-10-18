package classeAbstraite;

class Sphere extends Forme3D {
  private double rayon;

  Sphere(double rayon) {
    setRayon(rayon);
  } // Sphere()

  private void setRayon(double rayon) {
    if (rayon >= 0) {
      this.rayon = rayon;
    } else {
      System.err.println("Erreur: rayon invalide");
    } // else
  } // setRayon()

  @Override
  double volume() {
    return 4 * Math.PI / 3  * Math.pow(rayon, 3);
  } // volume()
} // Sphere