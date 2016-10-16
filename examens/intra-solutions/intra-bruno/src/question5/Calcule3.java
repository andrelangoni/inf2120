package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule3 {
  // Méthode 3 - interface
  public static void aire(Objet o)  {
    System.out.printf("Aire pour " + o.getClass().getSimpleName() + " : %.3f\n", o.aire());
  }

  public static void main(String[] args) {
    Carre carre = new Carre(2);
    Plan plan = new Plan();
    Sphere sphere = new Sphere(1);
    System.out.println("Méthode 3 - interface");
    aire(carre);
    aire(sphere);
    //aire(plan); // erreur
  }
}