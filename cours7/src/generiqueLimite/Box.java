package generiqueLimite;

@SuppressWarnings({"UnnecessaryBoxing", "WeakerAccess"})
public class Box<T> {

  private T t;

  public void set(T t) { this.t = t; }

  public T get() { return t; }

  public <U extends Number> void inspect(U u){
    System.out.println("T: " + t.getClass().getName());
    System.out.println("U: " + u.getClass().getName());
  }

  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>();
    integerBox.set(new Integer(10));
    integerBox.inspect(new Double(11d));
    //integerBox.inspect("some text"); // error: this is still String!
/*    integerBox.inspect(new Number() {
      @Override public int intValue() { return 0; }
      @Override public long longValue() { return 0; }
      @Override public float floatValue() { return 0; }
      @Override public double doubleValue() { return 0; }
    }); // inspect()*/
  } // main()
} // Box
