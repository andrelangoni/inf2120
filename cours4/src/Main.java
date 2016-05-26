public class Main {
    public static void main(String[] args) {
        //Pile.Noeud<Integer> p1 = new Pile.Noeud<Integer>(3, null);
        //Pile.Noeud<Integer> p2 = new Pile.Noeud<Integer>(7, p1);
        Pile<Double> p = new Pile<>(); // pile vide
        p.empiler(3.12d);
        p.empiler(7.1d);
        p.empiler(-4d);
        // pile contient -4, 7.1, 3.12
        try {
            p.depiler();
            Double x = p.sommet(); //x = 7.1
            int t = p.taille(); // t = 2
            // pile contient -7.1, 3.12
        } catch (PileVide pileVide) {
            pileVide.printStackTrace();
        }
        Double d = 1.1d;
    }
}
