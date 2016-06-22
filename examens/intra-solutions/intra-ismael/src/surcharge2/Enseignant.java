package surcharge2;

public class Enseignant extends Employe {
  public void valider(Employe emp) {
    System.out.println("Enseignant - valider(Employe)");
  }
  public void comparer(Object o) {
    System.out.println("Enseignant - comparer(Object)");
  }
  public void demenager(Enseignant ens) {
    System.out.println("Enseignant-demenager(Enseignant)");
  }
}