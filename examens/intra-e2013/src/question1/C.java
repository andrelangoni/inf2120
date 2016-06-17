package question1;

@SuppressWarnings("WeakerAccess")
public class C extends B {
  public int v;
  protected int x;
  private int z;

  //public int r = 0; valide; cache B.r

  public C() {
    j = k = 0;
    // n = 0; non car private dans A
    p = r = 0;
    // t = 0; non car private dans B
    v = x = z = 0;
  }
}
