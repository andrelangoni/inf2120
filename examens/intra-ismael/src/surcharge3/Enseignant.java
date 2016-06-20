package surcharge3;

public class Enseignant extends Employe {
  public void valider(Personne pers) {
    System.out.println("Enseignant - valider(Personne)");
  }
  public void comparer(Object o) {
    System.out.println("Enseignant - comparer(Object)");
  }
  public void demenager(Object o) {
    System.out.println("Enseignant-demenager(Object)");
  }
}