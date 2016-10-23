package question4;

// Hao
public class Main2 {
  public static Pile<Integer> obtenirLesNegatifs(Pile<Integer> p1) {
    Pile<Integer> pileNeg = new Pile<>();
    Pile<Integer> nouvellePile = new Pile<>();
    int taille = p1.taille();

    try {
      for (int i = 0; i < taille; i++) {
        int element = p1.depiler();

        if (element < 0) {
          pileNeg.empiler(element);
        }

        nouvellePile.empiler(element);
      }

      for (int i = 0; i < taille; i++) {
        int element2 = nouvellePile.depiler();
        p1.empiler(element2);
      }
    } catch (PileVide e) {
      e.printStackTrace();
    }

    return pileNeg;
  }

  public static void affichePile(Pile<Integer> pile) {
    int taille2 = pile.taille();

    for (int i = 0; i < taille2; i++) {
      try {
        System.out.print(pile.depiler() + " ");
      } catch (PileVide e) {
        e.printStackTrace();
      }
    }

    System.out.println();
  }

  public static void main(String[] args) {
    Pile<Integer> p1 = new Pile<>();
    p1.empiler(-9);
    p1.empiler(4);
    p1.empiler(-7);
    p1.empiler(2);
    p1.empiler(-3);

    Pile<Integer> p2 = obtenirLesNegatifs(p1);
    affichePile(p1);
    affichePile(p2);
  }
}
