import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    // lambda
    Predicate<Integer> p = x -> x > 10;
    // vs
    int x = 10;
    P k = new P();
    k.test(x);

    List<Integer> li = Arrays.asList(2,4,6,8);
    println("Toute la liste");
    li.stream().forEach(y -> {println(y);});
    println("liste inférieure à 5");
    li.stream().filter(z -> z < 5).forEach(System.out::println);
    println("2 premiers");
    li.stream().limit(2).forEach(System.out::println);

    li.stream().map(a -> new Double(a));
    li.stream().map(Double::new);
    Stream.generate(() -> new Integer(1)).limit(10);
    println("IntStream.iterate()");
    IntStream.iterate(1, b -> b + 1)
        .map(c -> c * 3 + 1)
        .filter(d -> d % 2 == 0)
        .limit(10).forEach(System.out::println);
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Main