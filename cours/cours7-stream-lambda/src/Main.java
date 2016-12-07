import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    exemple0();
    exemple1();
    System.out.println();
    exemple2();
  }

  private static void exemple0() {
    X fonction = new X();
    System.out.println();
    int n = 2;
    System.out.println(n + " + 1 = " + fonction.f(n));
  } // exemple3()


  private static void exemple1() {
    int x = 10;
    // lambda
    Predicate<Integer> p = y -> y > 10;

    System.out.println("avec lambda");
    System.out.print(x);
    System.out.println(p.test(x) ? " est plus grand que 10" : " est plus petit que 10");

    // vs
    P k = new P();
    k.test(x);

    println("avec Predicate");
    System.out.print(x);
    println(p.test(x) ? " est plus grand que 10" : " est plus petit que 10");
  } // exemple1()

  private static void exemple2() {
    List<Integer> li = Arrays.asList(2,4,6,8);
    println("Toute la liste");
    li.stream().forEach(y -> {
      System.out.print(y + " ");
    }); // fonction anonyme
    println("\nliste inférieure à 5");
    li.stream().filter(z -> z < 5).forEach(System.out::println);
    println("3 premiers");
    li.stream().limit(3).forEach(a -> {
      System.out.print(a + " ");
    }); // fonction anonyme

    li.stream().map(a -> new Double(a));
    li.stream().map(Double::new);
    Stream.generate(() -> new Integer(1)).limit(10);
    println("\nIntStream.iterate()");
    IntStream.iterate(1, b -> b + 1)
        .map(c -> c * 3 + 1)
        .filter(d -> d % 2 == 0)
        .limit(10).forEach(b -> {
          System.out.print(b + " ");
        }); // fonction anonyme
  } // exemple2()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Main