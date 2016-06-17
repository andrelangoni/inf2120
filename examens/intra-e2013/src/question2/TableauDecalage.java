package question2;

/**
 * Cette classe représente un Tableau à décalage. C'est un tableau de taille
 * fixe (choisi lors de la création) qui permet de déplacer les éléments vers
 * la gauche.
 */
@SuppressWarnings("WeakerAccess")
public class TableauDecalage extends Tableau {
  /**
   * Construit un tableau permettant les décalages vers la gauche.
   *
   * @param taille Nombre d'élément que va contenir le tableau. Le
   *               comportement du constructeur n'est pas défini si la taille est négative.
   */
  public TableauDecalage(int taille) {
    super(taille);
  } // TableauDecalage()

  /**
   * Déplace les éléments du tableau vers la gauche. Les éléments
   * qui se retrouveront hors du tableau sont perdus. Les cases vides à
   * la droite du tableau sont remplies avec la valeur en argument.
   *
   * @param decalage Indique le nombre de case pour le déplacement à gauche.
   * @param valeur   Valeur par défaut qui remplacera les valeurs à droite.
   *                 Exemple :
   *                 Le tableau t de taille 5 contenant : 3, 4, 1, 6, 5
   *                 nous appliquons un décalage de 2 cases vers la gauche et les cases
   *                 vide à droite seront remplies avec la valeur 8 :
   *                 t.decalageGauche( 2, 8 );
   *                 Après l'appel le tableau t contiendra : 1, 6, 5, 8, 8
   *                 *
   *                 Les valeurs 3 et 4 sont éjecter du tableau (perdues), les valeurs
   *                 1, 6, 5 sont décale de 2 cases et la valeur 8 est placée dans les
   *                 cases à droite.
   */
  public void decalageGauche(int decalage, int valeur) {
    assert ((decalage < taille() - 1));
    // Decalage a gauche
    for (int i = 0; i < (taille() - decalage); i++) {
      //tab[i] = tab[i + decalage];
      assigner(i, element(i + decalage));
    } // for

    // Deuxieme methode
//    System.arraycopy(tab, decalage, tab, 0, taille() - decalage);

    // Remplissage des cases de droite
    for (int j = (taille() - decalage); j < taille(); j++) {
      //tab[j] = valeur;
      assigner(j, valeur);
    } // for
  } // decalageGauche()
} // TableauDecalage
