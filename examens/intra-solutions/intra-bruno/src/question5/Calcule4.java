package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule4 {
  // Methode 4 - interface et genericite
  public <T extends ObjetAire> void aire(T objet) {
    System.out.printf("Aire pour " + objet.getClass().getSimpleName() + " : %.3f\n", objet.aire());
  }

  public static void main(String[] args) {
    Carre carre = new Carre(2);
    Plan plan = new Plan(1, 2);
    Sphere sphere = new Sphere(1);
    Calcule4 calcule4 = new Calcule4();
    System.out.println("Methode 4 - interface et genericite");
    calcule4.aire(carre);
    calcule4.aire(sphere);
    //println(aire(plan)); // erreur
  }
}