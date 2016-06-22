package surcharge3;

public class Personne {
  public void valider() {
    System.out.println("Personne-valider()");
  }
  public void comparer(Object o) {
    System.out.println("Personne-comparer(Object)");
  }
  public void demenager(Personne pers) {
    System.out.println("Personne-demenager(Personne)");
  }
}