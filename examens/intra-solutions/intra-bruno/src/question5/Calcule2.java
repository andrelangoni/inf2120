package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule2 {
  // Méthode 2 - polymorphisme
  public static double aire(Carre carre) {
    return carre.aire();
  } // aire()

  public static double aire(Sphere sphere) {
    return sphere.aire();
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    println("Méthode 2 - polymorphisme");
    println("Aire du carré: " + aire(carre));
    println("Aire de la sphère: " + aire(sphere));
    //println(aire(plan)); // erreur
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
