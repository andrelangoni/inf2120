package bruno1;

public class Cours {
  static final int DEFAUT = -1;

  public static <E> int recherche(E[] tableau, E element) {
    int position = DEFAUT;

    for (int i = 0; (position == DEFAUT) && (i < tableau.length); ++i) {
      if (tableau[i].equals(element)) {
        position = i;
      } // if
    } // for

    return position;
  } // recherche()

  public static <E> int recherche2(E[] tableau, E element) throws NoSuchFieldException {
    int i = 0;
    while (i < tableau.length && !tableau[i].equals(element)) {
      ++i;
    } // while

    if (i == tableau.length) {
      throw new NoSuchFieldException();
    } // if

    return i;
  } // recherche2()

  public static int rechercheBinaire(int[] tab, int element) throws NoSuchFieldException {
    int debut = 0;
    int fin = tab.length - 1;
    int milieu;

    //System.out.println("Recherche de " + String.valueOf(element));

    while (debut <= fin) {
      milieu = (debut + fin) / 2;
      //System.out.println("Milieu = " + String.valueOf(milieu));
      if (tab[milieu] == element) {
        return milieu;
      } else if (tab[milieu] < element) {
        debut = milieu + 1;
      } else {
        fin = milieu;
      } // else
    } // while

    return DEFAUT;
  } // rechercheBinaire()

} // Cours