package enumeration;

public enum Mois {JANVIER(1), FEVRIER(2), MARS(3), AVRIL(4), MAI(5), JUIN(6),
                  JUILLET(7), AOUT(8), SEPTEMBRE(9), OCTOBRE(10), NOVEMBRE(11), DECEMBRE(12);

    private int nbrJours;

    Mois(int nbrJours) {
        setNbrJours(nbrJours);
    } // Mois()

    public int getNbrJours() {
        return nbrJours;
    } // getNbrJours()

    public void setNbrJours(int nbrJours) {
        this.nbrJours = nbrJours;
    } // setNbrJours()
} // Mois
