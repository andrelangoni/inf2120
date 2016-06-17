package question3;

public abstract class Vehicule {
    protected String couleur;
    public Vehicule (String c) {
        this();
        System.out.println(quoi ());
    }
    public Vehicule () {
        System.out.println("Creation " +
                getClass().getSimpleName());
        couleur = "rouge";
    }
    public abstract String quoi();
    public String toString () {
        return "vehicule " + couleur;
    }
}
