package question1;

@SuppressWarnings("WeakerAccess")
public class D {
  public static A nouveau() {
    // oui car C est de type A
    return new C();
  }

  public static void main(String[] args) {
    A a = nouveau();
    System.out.println(a.getClass().getName());
  }
}
