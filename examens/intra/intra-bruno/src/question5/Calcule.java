package question5;

@SuppressWarnings("WeakerAccess")
public class Calcule {
  // pas d'interfaces ou de classes abstraites car on ne peut modifier les autres classes;
  // utilise la genericite ou instanceof n'est pas necessaire;
  // le polymorphisme suffit;
  public static double aire(Carre carre) {
    return 0d;
  } // aire()

  public static double aire(Sphere sphere) {
    return 0d;
  } // aire()

  public static void main(String[] args) {
    Carre carre = new Carre();
    Plan plan = new Plan();
    Sphere sphere = new Sphere();
    println(aire(carre));
    println(aire(sphere));
    //println(aire(plan)); erreur
  } // main()

  public static void println(Object o) {
    System.out.println(o);
  } // println()
} // Calcule
