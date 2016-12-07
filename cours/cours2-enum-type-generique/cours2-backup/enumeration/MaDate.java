package enumeration;

public class MaDate {
    private int jour;
    private Mois mois;
    private int annee;

    public MaDate(int jour, Mois mois, int annee) {
        setJour(jour);
        setMois(mois);
        setAnnee(annee);
    } // MaDate()

    public int getJour() {
        return jour;
    } // getJour()

    public void setJour(int jour) {
        this.jour = jour;
    } // setJour()

    public Mois getMois() {
        return mois;
    } // getMois()

    public void setMois(Mois mois) {
        this.mois = mois;
    } // setMois()

    public int getAnnee() {
        return annee;
    } // getAnnee()

    public void setAnnee(int annee) {
        this.annee = annee;
    } // setAnnee()

    @Override
    public String toString() {
        return "MaDate{" +
                "jour=" + jour +
                ", mois=" + mois +
                ", annee=" + annee +
                '}';
    } // toString()
} // MaDate