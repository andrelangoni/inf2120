package classeAbstraite;

public class Principale {
    public static void main(String[] args) {
        Cercle cercle = new Cercle(2);
        Rectangle rectangle = new Rectangle(2,2);
        Sphere sphere = new Sphere(2);
        CylindreDroit cylindreDroit = new CylindreDroit(cercle, 3);

        Forme2D[] forme2Ds = {cercle, rectangle};

        for (Forme2D forme2D : forme2Ds) {
            println("Aire = " + String.valueOf(forme2D.aire()) + " pour " + forme2D.getClass().getSimpleName());
        } // for

        Forme3D[] forme3Ds = {sphere, cylindreDroit};

        for (Forme3D forme3D : forme3Ds) {
            println("Volume = " + String.valueOf(forme3D.volume()) + " pour " + forme3D.getClass().getSimpleName());
        } // for
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()
} // classeAbstraite.Principale