import java.util.function.Predicate;

public class P implements Predicate<Integer> {
  @Override
  public boolean test(Integer x) {
    return false;
  } // test()
} // P
