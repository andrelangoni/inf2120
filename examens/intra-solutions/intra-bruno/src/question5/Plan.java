package question5;

@SuppressWarnings("WeakerAccess")
public class Plan extends Objet3D {
  private double longueur;
  private double largeur;

  public Plan(double longueur, double largeur) {
    this.longueur = longueur;
    this.largeur = largeur;
  }

  public double aire() {
    return longueur * largeur;
  } // aire()
}