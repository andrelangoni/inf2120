package recursion;

public class Main {
    public static void main(String[] args) {
        int somme = MMath.somme(5);
        println("Somme = " + String.valueOf(somme));
        int fibo = MMath.fibonnaci(10);
        println("Fibo = " + String.valueOf(fibo));
    } // main()

    public static int max(int[] t) {
        return max(t, 0, t.length - 1);
    } // max()

    private static int max(int[] t, int debut, int fin) {
        int r = 0;
        if (debut == fin) {
            r = t[debut];
        } else {
            int milieu = (debut + fin) / 2;
            int x1 = max(t, debut, milieu);
            int x2 = max(t, milieu + 1, fin);
            r = x1 < x2 ? x2 : x1;
        } // else
        return r;
    } // max()

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
