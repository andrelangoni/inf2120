package recursion;

public class Main {
    public static void main(String[] args) {
        int somme = MMath.somme(5);
        println("Somme = " + String.valueOf(somme));
        int fibo = MMath.fibonnaci(10);
        println("Fibo = " + String.valueOf(fibo));
    } // main()

    public static void f(int x) {
        int y;
        x += 2;
        y = m(2);
        println(y);
    } // f()

    public static int m(int x) {
        int y = 12;
        return y + x;
    } // m()

    public static void println(String s) {
        System.out.println(s);
    } // println()

    public static void println(Object o) {
        System.out.println(o);
    } // println()
}
