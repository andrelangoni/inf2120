public class Recursion {
  public static void main(String[] args) {
    System.out.println(fonction(2,2)); // 2.25
  }

  public static double fonction(double x, int n) {
    double valeur;
    if (n <= 0) {
      // cas limite (fin de la fonction = pas d'appel)
      valeur = 1 / x;
    } else {
      // appel de la fonction (recursif)
      // changer la valeur de n pour eviter la boucle infinie
      valeur = x + 1/fonction(x, n - 1);
    }
    return valeur;
  }
} // Recursion