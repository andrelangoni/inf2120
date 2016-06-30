import java.util.stream.IntStream;

public class MMath {

  public static void main(String[] args) {
    MMath.premier(
      IntStream.iterate(2, x -> x + 1)
    ).limit(10).forEach(System.out::println);
  } // main()

  public static IntStream premier(IntStream xs) {
    int p = xs.findFirst().getAsInt(); // get() voir avec prof
    return IntStream.concat(IntStream.of(p), MMath.premier(xs.filter(x -> (x % p) != 0)));
  }
}
