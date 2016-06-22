package question3;

public class Main {
  public static void main(String[] args) {
    Triangle t = new Triangle();
    Quadrilatere q = new Rectangle();
    ElementGraphique e = new Quadrilatere();
    Rectangle r = new Rectangle();

    ElementGraphique e2 = new Rectangle();

    t.afficher(); // de ElementGraphique.
    q.afficher(); // de Rectangle.
    e.afficher(); // de ElementGraphique.
    t.uneMethode(q); // uneMethode de ElementGraphique
    q.uneMethode(t); // uneMethode de Quadrilatere
    r.uneMethode(q); // uneMethode de Quadrilatere

    System.out.println(q.getClass().getName());
    q.uneMethode(r);
    // q est de type Quadrilatere (cache une instance de Rectangle)
  }
}
