package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule {
  public static void main(String[] args) {
    Carre carre = new Carre(2);
    Plan plan = new Plan(1, 2);
    Sphere sphere = new Sphere(1);

    try {
      System.out.println("Methode 1 - instanceof");
      afficheAire(carre);
      afficheAire(sphere);
      afficheAire(plan); // erreur
    } catch (Exception e) {
      System.out.println("Erreur lors du calcul d'aire");
    }
  }

  // Methode 1 - instanceof
  public static double aire(Object o) throws Exception {
    double d;

    if (o instanceof Carre) {
      d = ((Carre) o).aire();
    } else if (o instanceof Sphere) {
      d = ((Sphere) o).aire();
    } else {
      throw new Exception();
    }

    return d;
  }

  public static void afficheAire(Object o) throws Exception {
    System.out.printf("Aire pour " + o.getClass().getSimpleName() + " : %.3f\n", aire(o));
  }
}