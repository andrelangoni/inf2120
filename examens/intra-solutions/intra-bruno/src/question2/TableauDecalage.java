package question2;

/**
 * Cette classe represente un Tableau a decalage. C'est un tableau de taille
 * fixe (choisi lors de la creation) qui permet de deplacer les elements vers
 * la gauche.
 */
@SuppressWarnings("WeakerAccess")
public class TableauDecalage extends Tableau {
  /**
   * Construit un tableau permettant les decalages vers la gauche.
   *
   * @param taille Nombre d'element que va contenir le tableau. Le
   *               comportement du constructeur n'est pas defini si la taille est negative.
   */
  public TableauDecalage(int taille) {
    super(taille);
  }

  /**
   * Deplace les elements du tableau vers la gauche. Les elements
   * qui se retrouveront hors du tableau sont perdus. Les cases vides a
   * la droite du tableau sont remplies avec la valeur en argument.
   *
   * @param decalage Indique le nombre de case pour le deplacement a gauche.
   * @param valeur   Valeur par defaut qui remplacera les valeurs a droite.
   *                 Exemple :
   *                 Le tableau t de taille 5 contenant : 3, 4, 1, 6, 5
   *                 nous appliquons un decalage de 2 cases vers la gauche et les cases
   *                 vide a droite seront remplies avec la valeur 8 :
   *                 t.decalageGauche( 2, 8 );
   *                 Après l'appel le tableau t contiendra : 1, 6, 5, 8, 8
   *                 *
   *                 Les valeurs 3 et 4 sont ejectees du tableau (perdues), les valeurs
   *                 1, 6, 5 sont decalees de 2 cases et la valeur 8 est placee dans les
   *                 cases a droite.
   */
  public void decalageGauche(int decalage, int valeur) {
    assert (decalage < taille() - 1);
    // Decalage a gauche
    for (int i = 0; i < (taille() - decalage); ++i) {
      //tab[i] = tab[i + decalage];
      assigner(i, element(i + decalage));
    }

    // Deuxieme methode
    //System.arraycopy(tab, decalage, tab, 0, taille() - decalage);

    // Remplissage des cases de droite
    for (int j = (taille() - decalage); j < taille(); ++j) {
      //tab[j] = valeur;
      assigner(j, valeur);
    }
  }
}