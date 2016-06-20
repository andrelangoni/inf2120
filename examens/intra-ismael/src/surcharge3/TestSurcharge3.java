package surcharge3;

public class TestSurcharge3 {
  public static void main(String[] args) {
    Enseignant ens = new Enseignant();
    ens.valider(ens);
    ens.comparer(ens);
    ens.demenager(ens);
  }
}