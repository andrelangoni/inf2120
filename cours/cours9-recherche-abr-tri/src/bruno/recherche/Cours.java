package bruno.recherche;

class Cours<E extends Comparable<E>> {
  static final int DEFAUT = -1;

  int recherche(E[] tab, E element) {
    for (int i = 0; i < tab.length; ++i) {
      if (tab[i].equals(element)) { return i; } // if
    } // for
    return DEFAUT;
  } // recherche()

  int recherche2(E[] tab, E element) throws Exception {
    int i = 0;
    while (i < tab.length && !tab[i].equals(element)) {
      ++i;
    } // while

    if (i == tab.length) { throw new Exception(); }
    return i;
  } // recherche2()

  int rechercheBinaire(E[] tab, E element) throws Exception {
    int debut = 0;
    int fin = tab.length - 1;
    int milieu;

    //System.out.println("Recherche de " + String.valueOf(element));

    while (debut <= fin) {
      milieu = (debut + fin) / 2;
      //System.out.println("Milieu = " + String.valueOf(milieu));
      if (tab[milieu].equals(element)) {
        return milieu;
      } else if (tab[milieu].compareTo(element) < 0) {
        debut = milieu + 1;
      } else {
        fin = milieu;
      } // else
    } // while

    return DEFAUT;
  } // rechercheBinaire()
} // Cours