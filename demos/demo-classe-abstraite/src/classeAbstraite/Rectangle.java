package classeAbstraite;

class Rectangle extends Forme2D {
  private double hauteur;
  private double largeur;

  Rectangle(double hauteur, double largeur) {
    setHauteur(hauteur);
    setLargeur(largeur);
  } // Rectangle()

  private void setHauteur(double hauteur) {
    if (hauteur >= 0) {
      this.hauteur = hauteur;
    } else {
      System.err.println("Erreur: hauteur invalide");
    } // else
  } // setHauteur()

  private void setLargeur(double largeur) {
    if (largeur >= 0) {
      this.largeur = largeur;
    } else {
      System.err.println("Erreur: largeur invalide");
    } // else
  } // setLargeur()

  @Override
  double aire() {
    return hauteur * largeur;
  } // aire()
} // Rectangle