package heritage;

public class Bien {
    private double prixEtalage;

    public Bien(double prixEtalage) {
        setPrixEtalage(prixEtalage);
    } // Bien()

    public double getPrixEtalage() {
        return prixEtalage;
    } // getPrixEtalage()

    public void setPrixEtalage(double prixEtalage) {
        if (prixEtalage >= 0) {
            this.prixEtalage = prixEtalage;
        } // if
    } // setPrixEtalage()

    public double prix() {
        return getPrixEtalage();
    } // prix()

} // Bien