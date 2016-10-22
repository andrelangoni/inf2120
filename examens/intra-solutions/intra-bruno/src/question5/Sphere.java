package question5;

@SuppressWarnings("WeakerAccess")
public class Sphere extends Objet3D implements ObjetAire {
  private double rayon;

  public Sphere(double rayon) {
    this.rayon = rayon;
  }

  @Override
  public double aire() {
    // surface = 4 * PI * (r ^ 2)
    return 4 * Math.PI * Math.pow(rayon, 2);
  } // aire()
} // Sphere
