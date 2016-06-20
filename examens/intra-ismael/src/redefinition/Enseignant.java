package redefinition;

public class Enseignant extends Employe {
  public boolean equals(Object obj) {
    System.out.println("Enseignant-equals(Object)");
    return true;
  }
  public String toString() {
    System.out.println("Enseignant - toString()");
    return "";
  }
}
