import java.util.Iterator;

public class R implements Iterable<Integer> {
  private int a;
  private int b;
  private int c;

  public R(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new RI(this);
  }

  public class RI implements Iterator<Integer> {
    R r;
    Integer p;

    public RI(R r) {
      this.r = r;
      p = r.a;
    }

    @Override
    public boolean hasNext() {
      return p <= r.b;
    }

    @Override
    public Integer next() {
      Integer resultat = p;
      p += r.c;
      return resultat;
    }
  }
}