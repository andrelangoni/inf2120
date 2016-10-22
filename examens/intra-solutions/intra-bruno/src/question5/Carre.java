package question5;

@SuppressWarnings("WeakerAccess")
public class Carre extends Objet2D implements ObjetAire {
  private double longueur;

  public Carre(double longueur) {
    this.longueur = longueur;
  }

  @Override
  public double aire() {
    return Math.pow(longueur, 2);
  } // aire()
} // Carre
