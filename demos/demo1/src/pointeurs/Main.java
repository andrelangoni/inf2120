package pointeurs;

public class Main {
    public static void main(String[] args) {
        Couleur c1 = new Couleur(1, 4, 6);
        Couleur c2 = c1;
        Couleur c3 = (Couleur) c1.clone();

        printC(c1, c2, c3);
        c2.setRouge(100);
        printC(c1, c2, c3);
        c1.blanchir();
        printC(c1, c2, c3);
    } // main()

    private static void printC(Couleur c1, Couleur c2, Couleur c3) {
        println(c1.toString());
        println(c2.toString());
        println(c3.toString());
    } // printC()

    private static void println(String s) {
        System.out.println(s);
    } // println()
} // pointeurs.Main