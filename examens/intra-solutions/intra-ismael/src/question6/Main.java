package question6;

public class Main {
  public static void main(String[] args) {
    afficherRecursive(3);
  } // main()

  public static void afficherRecursive(int n) {
    // Cas de base
    if (n == 1) {
      println(n);
    } else { // Cas général
      afficherRecursive(n - 1);
      println(n);
    } // else
    // Cas général
  } // afficherRecursive()

  public static String inverserChaine(String chaine) {
    // Validation
    if ((chaine == null) || (chaine.length() <= 1)) {
      return chaine;
    } // if

    // Cas de base
    return inverserChaine(chaine.substring(1)) + chaine.charAt(0);
  } // inverserChaine()

  public static boolean estUnPalindrome(String chaine) {
    String inverse = inverserChaine(chaine);
    return chaine.equals(inverse);
  } // estUnPalindrome()

  public static void println(String s) {
    System.out.println(s);
  } // println()

  public static void println(int n) {
    System.out.println(n);
  } // println()
} // Main