package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule4 {
  // Méthode 4 - généricité
  public <T extends Carre> double aire(T objet) {
    return objet.aire();
  } // aire()

  public <T extends Sphere> double aire(T objet) {
    return objet.aire();
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    Calcule4 calcule4 = new Calcule4();
    println("Méthode 4 - généricité");
    println("Aire du carré: " + calcule4.aire(carre));
    println("Aire de la sphère: " + calcule4.aire(sphere));
    //println(aire(plan)); // erreur
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
