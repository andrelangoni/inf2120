package question2;

public class Main {
  public static void main(String[] args) {
    A a1 = new A ();
    A a2 = new A (15);
    B b = new B (100);
    System.out.println("Debug pour voir les valeurs");
    A a3 = new B(1);
    System.out.println(a3.getClass().getName());
    b.w = 2;
  }
}
