package question2;

@SuppressWarnings("WeakerAccess")
public class Tableau {
  // tableau à taille fixe. (pas de ArrayList)
  int[] tab;

  /**
   * Construit un Tableau à taille fixe.
   *
   * @param taille Nombre d'élément que va contenir le tableau. Le
   *               comportement du constructeur n'est pas défini si la taille est négative.
   */
  public Tableau(int taille) {
    assert (taille >= 0);
    tab = new int[taille];
  }

  /**
   * Lit un élément du tableau.
   *
   * @param position Une valeur de 0 à taille - 1 indiquant la position de
   *                 l'élément à lire. Le comportement n'est pas défini si la position est
   *                 négative ou plus grande ou égal à la taille.
   * @return La valeur lue.
   */
  public int element(int position) {
    assert ((position >= 0) && (position < taille() - 1));
    return tab[position];
  }

  /**
   * Place une valeur dans le tableau.
   *
   * @param position Une valeur de 0 à taille - 1 indiquant la position de
   *                 l'élément à assigner. Le comportement n'est pas défini si la position
   *                 est négative ou plus grande ou égal à la taille.
   * @param element  Valeur placé dans le tableau.
   */
  public void assigner(int position, int element) {
    assert ((position >= 0) && (position < taille() - 1));
    tab[position] = element;
  }

  /**
   * Retourne le nombre de cases que contient le tableau.
   *
   * @return La taille du tableau.
   */
  public int taille() {
    return tab.length;
  }

  public void print() {
    for (int i : tab) {
      System.out.print(String.valueOf(i) + " ");
    } // for
    System.out.println();
  } // print()

} // Tableau
