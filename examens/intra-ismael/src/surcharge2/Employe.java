package surcharge2;

public class Employe extends Personne {
  public void valider(Object o) {
    System.out.println("Employe-valider(Object)");
  }
  public void comparer(Employe emp) {
    System.out.println("Employe-comparer(Employe)");
  }
  public void demenager(Object o) {
    System.out.println("Employe - demenager(Object)");
  }
}