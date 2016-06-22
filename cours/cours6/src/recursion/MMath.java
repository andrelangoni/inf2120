package recursion;

@SuppressWarnings("WeakerAccess")
public class MMath {
  public static int somme(int n) {
    int s = 0;
    if (n != 0) {
      s = n + somme(n - 1);
    } // if
    return s;
  } // somme()

  public static int factoriel(int n) {
    int s = 1;
    if (n != 0) {
      s = n * MMath.factoriel(n - 1);
    } // if
    return s;
  } // factoriel()

  public static int fibonnaci(int n) {
    int s = n;
    if (n > 1) {
      s = fibonnaci(n - 2) + fibonnaci(n - 1);
    } // if
    return s;
  } // fibonnaci()

  public static void hanoi(int nbDisques, char debut, char fin, char intermediaire) {
    if (nbDisques != 0) {
      hanoi(nbDisques - 1, debut, intermediaire, fin);
      System.out.println(debut + "-->" + fin);
      hanoi(nbDisques - 1, intermediaire, fin, debut);
    } // if
  } // hanoi()
} // MMath
