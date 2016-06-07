package question3;

public class Voiture extends Vehicule {
    @SuppressWarnings("FieldCanBeLocal")
    private String marque = "Volvo";
    public Voiture(String couleur) {
        super(couleur);
    }
    public Voiture() {
        couleur = "jaune";
    }
    public String quoi () {
        return "voiture";
    }
    public String toString() {
        return super.toString() + " / " +
                marque;
    }
}
