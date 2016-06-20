package question3;

public class TestVehicule {
    public static void info(Vehicule v) {
        System.out.println(v.quoi() + " "
                + v.toString());
    }
    public static void main(String[] args) {
        Vehicule v1 = new Voiture();
        info(v1);
        //noinspection UnnecessaryLocalVariable
        Avion a1 = new Avion("bleu");
        v1 = a1;
        info(v1);
    }
}
