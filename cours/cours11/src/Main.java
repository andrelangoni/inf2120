import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

  }

  public static <E extends Comparable> void triRapide_R(E[] tab, int debut, int fin) {
    if (debut < fin) { // if (fin - debut) > k { ... k appartient a [5,15]
      E pivot = tab[(debut + fin) / 2]; // (tab[debut] + tab[fin]) / 2
      int i = debut;
      int j = fin;

      // Partition
      while (i < j) {
        while ((i < j) && (tab[i].compareTo(pivot) < 0)) {
          ++i;
        } // while()
        while ((i < j) && (tab[j].compareTo(pivot) > 0)) {
          --j;
        } // while()

        E temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
        ++i;
        --j;
      } // while

      triRapide_R(tab, debut, i - 1);
      triRapide_R(tab, i, fin);
      // triInsertion(tab)
    } // if ... else {
                        // tri insertion
                        // rapide pour les petits tableaux
                  // }
  } // triRapide_R()

  public static <E extends Comparable> void triRapide(E[] tab) {
    triRapide_R(tab, 0, tab.length - 1);
  } // triRapide()
} // Main