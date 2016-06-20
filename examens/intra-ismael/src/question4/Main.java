package question4;

public class Main {
  public static Pile<Integer> obtenirLesNegatifs(Pile<Integer> p1) {
    Pile<Integer> negatifs = null;
    Pile<Integer> temp = new Pile<>();
    Integer i;

    if ((p1 != null) && !p1.estVide()) {
      // Parcourir tous les éléments de la pile du début à la fin
      negatifs = new Pile<>();

      while (!p1.estVide()) {
        try {
          i = p1.depiler();
          temp.empiler(i);
          if (i < 0) {
            negatifs.empiler(i);
          } // if
        } catch (PileVide e) {
          e.printStackTrace();
        } // catch
      } // while

      // Retour à p1 originale
      while (!temp.estVide()) {
          try {
            i = temp.depiler();
            p1.empiler(i);
          } catch (PileVide e) {
            e.printStackTrace();
          } // catch
        } // while
      } // if

    return negatifs;
  } // obtenirLesNegatifs()
} // Main
