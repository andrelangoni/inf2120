package classeAbstraite;

public class Sphere extends Forme3D {
    private double rayon;

    public Sphere(double rayon) {
        setRayon(rayon);
    } // classeAbstraite.Sphere()

    public double getRayon() {
        return rayon;
    } // getRayon()

    public void setRayon(double rayon) {
        if (rayon >= 0) {
            this.rayon = rayon;
        } // if
    } // setRayon()

    @Override
    double volume() {
        return 4d/3d * Math.PI * Math.pow(rayon, 3);
    } // volume()
} // classeAbstraite.Sphere