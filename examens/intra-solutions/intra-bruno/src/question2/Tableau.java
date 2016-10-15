package question2;

@SuppressWarnings("WeakerAccess")
public class Tableau {
  // tableau a taille fixe. (pas de ArrayList)
  int[] tab;

  /**
   * Construit un Tableau a taille fixe.
   *
   * @param taille Nombre d'element que va contenir le tableau. Le
   *               comportement du constructeur n'est pas defini si la taille est negative.
   */
  public Tableau(int taille) {
    assert taille >= 0;
    tab = new int[taille];
  }

  /**
   * Lit un element du tableau.
   *
   * @param position Une valeur de 0 a taille - 1 indiquant la position de
   *                 l'element a lire. Le comportement n'est pas defini si la position est
   *                 negative ou plus grande ou egal a la taille.
   * @return La valeur lue.
   */
  public int element(int position) {
    assert (position >= 0) && (position < taille());
    return tab[position];
  }

  /**
   * Place une valeur dans le tableau.
   *
   * @param position Une valeur de 0 a taille - 1 indiquant la position de
   *                 l'element a assigner. Le comportement n'est pas defini si la position
   *                 est negative ou plus grande ou egal a la taille.
   * @param element  Valeur place dans le tableau.
   */
  public void assigner(int position, int element) {
    assert (position >= 0) && (position < taille());
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
  }

}