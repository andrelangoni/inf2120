package question3;

public class Avion extends Vehicule {
    @SuppressWarnings("FieldCanBeLocal")
    private int nbrMoteurs = 4;

    public Avion(String couleur) {
        super(couleur);
        System.out.println(couleur + " / "
                + getNbrMoteursExtra()
                + " moteurs en extra");
    }
    public String quoi() {
        return "avion " + couleur;
    }
    public int getNbrMoteursExtra() {
        return nbrMoteurs - 2;
    }
}
