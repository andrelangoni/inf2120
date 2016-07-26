package enumeration;

public class Main {
    public static void main(String[] args) {
        MaDate date = new MaDate(20, Mois.MAI, 2016);

        println(date.toString());

        for (Mois mois : Mois.values()) {
            println(mois.name() + " " + String.valueOf(mois.ordinal()));
        } // for
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()
} // Main