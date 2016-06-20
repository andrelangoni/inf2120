package surcharge3;

public class Employe extends Personne {
  public void valider(Object o) {
    System.out.println("Employe-valider(Object)");
  }
  public void comparer(Personne pers) {
    System.out.println("Employe-comparer(Personne)");
  }
  public void demenager() {
    System.out.println("Employe - demenager()");
  }
}