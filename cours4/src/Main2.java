public class Main2 {
    public static void main(String[] args) {
        File<Integer> p = new File<>(); // file vide
        p.enfiler(3);
        p.enfiler(7);
        p.enfiler(-4);
        // pile contient -4, 7, 3
        try {
            p.defiler();
            Integer tete = p.tete(); //x = 7.1
            println("Tete: " + String.valueOf(tete));
            int taille = p.taille(); // t = 2
            println("Taille: " + String.valueOf(taille));
            // pile contient -4, 7
        } catch (FileVide e) {
            e.printStackTrace();
        } // catch
        //Double d = 1.1d;
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()

    public static void println() {
        System.out.println();
    } // println()

    public static void print(String s) {
        System.out.print(s);
    } // print()
} // Main
