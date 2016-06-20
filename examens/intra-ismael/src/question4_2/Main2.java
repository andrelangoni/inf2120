package question4_2;

@SuppressWarnings("WeakerAccess")
public class Main2 {
  public static Pile<Integer> obtenirLesNegatifs(Pile<Integer> p1) {
    Pile<Integer> negatifs = null;

    if ((p1 != null) && !p1.isEmpty()) {
      negatifs = new Pile<>();
      // Parcourir tous les éléments de la pile du début à la fin
      for (Integer nombre : p1) {
        if (nombre < 0) {
          negatifs.empiler(nombre);
        } // if
      } // for
    } // if

    return negatifs;
  } // obtenirLesNegatifs()
} // Main2