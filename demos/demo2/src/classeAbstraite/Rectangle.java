package classeAbstraite;

public class Rectangle extends Forme2D {
    private double hauteur;
    private double largeur;

    public Rectangle(double hauteur, double largeur) {
        setHauteur(hauteur);
        setLargeur(largeur);
    } // classeAbstraite.Rectangle()

    public double getHauteur() {
        return hauteur;
    } // getHauteur()

    public void setHauteur(double hauteur) {
        if (hauteur >= 0) {
            this.hauteur = hauteur;
        } // if
    } // setHauteur()

    public double getLargeur() {
        return largeur;
    } // getLargeur()

    public void setLargeur(double largeur) {
        if (largeur >= 0) {
            this.largeur = largeur;
        } // if
    } // setLargeur()

    @Override
    double aire() {
        return hauteur * largeur;
    } // aire()
} // classeAbstraite.Rectangle