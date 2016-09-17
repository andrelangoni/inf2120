package classeAbstraite;

class CylindreDroit extends Forme3D {
  private Forme2D base;
  private double hauteur;

  CylindreDroit(Forme2D base, double hauteur) {
    setBase(base);
    setHauteur(hauteur);
  } // CylindreDroit()

  private void setBase(Forme2D base) {
    this.base = base;
  } // setBase()

  private void setHauteur(double hauteur) {
    if (hauteur >= 0) {
      this.hauteur = hauteur;
    } else {
      System.err.println("Erreur: hauteur invalide");
    } // else
  } // setHauteur()

  @Override
  double volume() {
    return base.aire() * hauteur;
  } // volume()
} // CylindreDroit