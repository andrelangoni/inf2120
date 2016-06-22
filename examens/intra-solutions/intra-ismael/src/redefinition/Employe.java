package redefinition;

public class Employe extends Personne {
  public boolean equals(Object obj) {
    System.out.println("Employe-equals(Object)");
    return true;
  }
  public String toString() {
    System.out.println("Employe-toString()");
    return "";
  }
}
