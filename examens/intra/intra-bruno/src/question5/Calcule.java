package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule {
  // pas d'interfaces ou de classes abstraites car on ne peut modifier les autres classes;
/*  public static double aire(Carre carre) {
    return 0d;
  } // aire()

  public static double aire(Sphere sphere) {
    return 1d;
  } // aire()*/

  // pas de polymorphisme car une seule méthode permise
  // pas de généricité car on ne peut pas changer les classes


  public static double aire(Object o) {
    double d;
    if (o instanceof Carre) {
      d = 0;
    } else if (o instanceof Sphere) {
      d = 1;
    } else {
      d = -1;
      System.out.println("Erreur");
    } // else
    return d;
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    println(aire(carre));
    println(aire(sphere));
    println(aire(plan)); //erreur
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
