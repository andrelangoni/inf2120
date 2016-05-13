package classeAbstraite;

public class CylindreDroit extends Forme3D {
    private Forme2D base;
    private double hauteur;

    public CylindreDroit(Forme2D base, double hauteur) {
        setBase(base);
        setHauteur(hauteur);
    } // classeAbstraite.CylindreDroit()

    public Forme2D getBase() {
        return base;
    } // getBase()

    public void setBase(Forme2D base) {
        this.base = base;
    } // setBase()

    public double getHauteur() {
        return hauteur;
    } // getHauteur()

    public void setHauteur(double hauteur) {
        if (hauteur >= 0) {
            this.hauteur = hauteur;
        } // if
    } // setHauteur()

    @Override
    double volume() {
        return base.aire() * hauteur;
    } // volume()
} // classeAbstraite.CylindreDroit