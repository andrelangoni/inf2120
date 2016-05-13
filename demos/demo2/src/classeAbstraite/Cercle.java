package classeAbstraite;

public class Cercle extends Forme2D {
    private double rayon;

    public Cercle(double rayon) {
        setRayon(rayon);
    } // classeAbstraite.Cercle()

    public double getRayon() {
        return rayon;
    } // getRayon()

    public void setRayon(double rayon) {
        if (rayon >= 0) {
            this.rayon = rayon;
        } // if
    } // setRayon()

    @Override
    double aire() {
        return Math.PI * Math.pow(rayon, 2);
    } // aire()
} // classeAbstraite.Cercle