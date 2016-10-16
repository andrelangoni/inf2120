package question5;

@SuppressWarnings("WeakerAccess")
public class Sphere extends Objet3D implements Objet {
  private double rayon;

  public Sphere(double rayon) {
    this.rayon = rayon;
  }

  @Override
  public double aire() {
    return Math.PI * Math.pow(rayon, 2);
  } // aire()
} // Sphere
