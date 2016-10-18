package classeAbstraite;

public class Principale {
  public static void main(String[] args) {
    Cercle cercle = new Cercle(2);
    Rectangle rectangle = new Rectangle(2, 2);
    Sphere sphere = new Sphere(2);
    CylindreDroit cylindreDroit = new CylindreDroit(cercle, 3);

    Forme2D[] forme2Ds = {cercle, rectangle};

    for (Forme2D forme2D : forme2Ds) {
      System.out.printf("Aire = %.3f pour " + forme2D.getClass().getSimpleName() + "\n", forme2D.aire());
    } // for

    Forme3D[] forme3Ds = {sphere, cylindreDroit};

    for (Forme3D forme3D : forme3Ds) {
      System.out.printf("Volume = %.3f pour " + forme3D.getClass().getSimpleName() + "\n", forme3D.volume());
    } // for
  } // main()
} // Principale