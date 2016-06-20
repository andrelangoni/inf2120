package redefinition;
public class Personne {
  public boolean equals(Object obj) {
    System.out.println("Personne-equals(Object)");
    return true;
  }
  public String toString() {
    System.out.println("Personne-toString()");
    return "";
  }
}