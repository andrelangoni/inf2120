public class Main {

  public static void main(String[] args) {
    //System.out.println("Hello World!");

    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(1, 2);
    System.out.println(f1 == f2);
    println(f1.toString());
    println(f2.toString());

    Fraction2 f3 = new Fraction2(1, 2);
    Fraction2 f4 = new Fraction2(1, 2);
    Fraction2 f5 = new Fraction2(1, 3);
    println(f3.sontEgaux(f4) ? "f3 egal a f4" : "f3 n'est pas egal a f4");
    println(f4.neSontPasEgaux(f5) ? "f4 n'est pas egal a f5" : "f4 est egal a f5");
  } // main()

  public static void println(String s) {
    System.out.println(s);
  } // println()

  public static void tri(Object[] tab) {

  } // tri()

  public static Comparable min(Comparable x, Comparable y) {
    return x.plusPetitQue(y) ? x : y;
  }
} // Main
