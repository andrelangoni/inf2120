package nombre;

public class Fraction implements Nombre<Fraction> {
  public static final int DENOM_DEFAUT = 1;
  private int num = 0; // numerateur
  private int denom = DENOM_DEFAUT; // denominateur

  public Fraction() {
  }

  public Fraction(int num, int denom) {
    setNum(num);
    setDenom(denom);
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getDenom() {
    return denom;
  }

  public void setDenom(int denom) {
    if (denom != 0) {
      this.denom = denom;
    }
  }

  @Override
  public Fraction add(Fraction x) {
    // (ad + bc) / (bd)
    return new Fraction(num * x.getDenom() + denom * x.getNum(), (denom * x.getDenom()));
  }

  @Override
  public Fraction sub(Fraction x) {
    // (ad - bc) / (bd)
    return new Fraction(num * x.getDenom() - denom * x.getNum(), (denom * x.getDenom()));
  }

  @Override
  public Fraction mul(Fraction x) {
    // (ac) / (bd)
    return new Fraction(num * x.getNum(), (denom * x.getDenom()));
  }

  @Override
  public Fraction div(Fraction x) {
    // (ad) / (bc)
    return new Fraction(num * x.getDenom(), (denom * x.getNum()));
  }

  @Override
  public boolean equals(Object obj) {
    boolean sontEgaux = false;

    if ((null != obj) && (obj instanceof Fraction)) {
      Fraction temp = (Fraction) obj;
      sontEgaux = num * temp.getDenom() == denom * temp.getNum();
    } // if

    return sontEgaux;
  } //equals()

  @Override
  public String toString() {
    return String.valueOf(num) + "/" + String.valueOf(denom);
  }
} // Fraction