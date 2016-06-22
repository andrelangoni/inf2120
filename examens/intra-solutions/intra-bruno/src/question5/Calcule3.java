package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule3 {
  // Méthode 3 - interface
  public static double aire(Objet o)  {
    return o.aire();
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    println("Méthode 3 - interface");
    println("Aire du carré: " + aire(carre));
    println("Aire de la sphère: " + aire(sphere));
    //println(aire(plan)); // erreur
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
