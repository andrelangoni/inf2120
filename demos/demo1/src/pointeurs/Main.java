package pointeurs;

public class Main {
  public static void main(String[] args) {
    Couleur c1 = new Couleur(1, 4, 6);
    Couleur c2 = c1;
    Couleur c3 = (Couleur) c1.clone();

    printCouleur(c1, c2, c3);

    c2.setRouge(100);
    printCouleur(c1, c2, c3);

    c1.blanchir();
    printCouleur(c1, c2, c3);
  }

  private static void printCouleur(Couleur c1, Couleur c2, Couleur c3) {
    println("c1: " + c1.toString());
    println("c2: " + c2.toString());
    println("c3: " + c3.toString());
    System.out.println();
  }

  private static void println(String s) {
    System.out.println(s);
  }
}