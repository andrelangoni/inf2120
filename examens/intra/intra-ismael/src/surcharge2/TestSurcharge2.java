package surcharge2;

public class TestSurcharge2 {
  public static void main(String[] args) {
    Employe emp = new Employe();
    Enseignant ens = new Enseignant();
    ens.valider(ens);
    ens.comparer(ens);
    ens.demenager(emp);
  }
}