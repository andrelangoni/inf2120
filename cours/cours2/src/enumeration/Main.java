package enumeration;

public class Main {
    public static void main(String[] args) {
        Currency coin = Currency.PENNY;
        println(coin.name() + " " + String.valueOf(coin.ordinal()));

        for (Currency currency : Currency.values()) {
            println(currency.name() + " " + currency.getValue()  + " " + String.valueOf(currency.ordinal()));
        } // for
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()
} // Main