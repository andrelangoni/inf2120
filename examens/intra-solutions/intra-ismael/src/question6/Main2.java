package question6;

public class Main2 {
  public static void main(String[] args) {
    afficherRecursive(5);
    System.out.println(inverserChaine("bon"));
  }

  public static void afficherRecursive(int n) {
    // Cas de base (condition d'arret)
    if (n == 1) {
      System.out.println(n);
    } else {
      // Appel de la methode
      afficherRecursive(n - 1);
      System.out.println(n);
    } // else
  }

  public static String inverserChaine(String chaine) {
    String inverse = "";
    for (int i = chaine.length() - 1; i >= 0; --i) {
      inverse += chaine.charAt(i);
    }
    return inverse;
  }


}
