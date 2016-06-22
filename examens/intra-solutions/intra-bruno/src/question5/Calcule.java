package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule {
  // Méthode 1 - instanceof
  public static double aire(Object o) throws Exception {
    double d;
    if (o instanceof Carre) {
      d = ((Carre) o).aire();
    } else if (o instanceof Sphere) {
      d = ((Sphere) o).aire();
    } else {
      throw new Exception();
    } // else
    return d;
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    try {
      println("Méthode 1 - instanceof");
      println("Aire du carré: " + aire(carre));
      println("Aire de la sphère: " + aire(sphere));
      //println(aire(plan)); // erreur
    } catch (Exception e) {
      System.out.println("Erreur");
    }
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
