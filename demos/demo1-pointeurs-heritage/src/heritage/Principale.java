package heritage;

import heritage.biens.*;

public class Principale {
    public static void main(String[] args) {
        Bien[] biens = new Bien[3];

        Legume aubergine = new Legume(4.99d);
        Livre algebre = new Livre(83.95d);
        Meuble table = new Meuble(699d);

        biens[0] = aubergine;
        biens[1] = algebre;
        biens[2] = table;

        for (Bien bien : biens) {
            System.out.printf("Prix = %.2f", bien.prix());
            println();
        } // for

        System.out.printf("Montant facture = %.2f", montantFacture(biens));
        println();
    } // main()

    private static double montantFacture(Bien[] biens) {
        double montantTotal = 0d;

        for (Bien bien : biens) {
            montantTotal += bien.prix();
        } // for

        return montantTotal;
    } // montantFacture()

    private static void println() {
        System.out.println();
    } // println()
} // Principale