package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule2 {
  // Méthode 2 - polymorphisme
  public static double aire(Carre carre) {
    return carre.aire();
  }

  public static double aire(Sphere sphere) {
    return sphere.aire();
  }

  public static void main(String[] args) {
    Carre carre = new Carre(2);
    Plan plan = new Plan();
    Sphere sphere = new Sphere(1);
    System.out.println("Méthode 2 - polymorphisme");
    System.out.printf("Aire pour " + carre.getClass().getSimpleName() + " : %.3f\n", aire(carre));
    System.out.printf("Aire pour " + sphere.getClass().getSimpleName() + " : %.3f\n", aire(sphere));
    //println(aire(plan)); // erreur
  }

}