package nombre;

public class NDouble implements Nombre<NDouble> {
  private double valeur;

  public NDouble(double valeur) {
    setValeur(valeur);
  }

  public double getValeur() {
    return valeur;
  }

  public void setValeur(double valeur) {
    this.valeur = valeur;
  }

  @Override
  public NDouble add(NDouble x) {
    return new NDouble(valeur + x.getValeur());
  }

  @Override
  public NDouble sub(NDouble x) {
    return new NDouble(valeur - x.getValeur());
  }

  @Override
  public NDouble mul(NDouble x) {
    return new NDouble(valeur * x.getValeur());
  }

  @Override
  public NDouble div(NDouble x) {
    NDouble resultat = null;

    if (x.getValeur() != 0) {
      resultat = new NDouble(valeur / x.getValeur());
    }

    return resultat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NDouble nDouble = (NDouble) o;

    return Double.compare(nDouble.valeur, valeur) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(valeur);
    return (int) (temp ^ (temp >>> 32));
  }

  @Override
  public String toString() {
    return String.valueOf(valeur);
  }
}