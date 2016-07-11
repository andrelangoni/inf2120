package abr;


/**
 * Quelques méthodes sur l'ABR.
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Mars 2011
 *          Modifié en Avril 2014
 */
public class ArbreBinaireDemo {
  /**
   * Parcours préfixe de l'arbre binaire (RGD).
   *
   * @param racine La racine de l'ABR
   */
  public static <T> void parcoursPrefixe(NoeudABR<T> racine) {
    if (racine != null) {
      System.out.println(racine.getElement() + " ");
      System.out.println("Gauche de " + racine.getElement());
      parcoursPrefixe(racine.getGauche());
      System.out.println("Droite de " + racine.getElement());
      parcoursPrefixe(racine.getDroit());
    } // if
  } // parcoursPrefixe()

  /**
   * Parcours infixe de l'arbre binaire (GRD).
   *
   * @param racine La racine de l'ABR
   */
  public static <T> void parcoursInfixe(NoeudABR<T> racine) {
    if (racine != null) {
      parcoursInfixe(racine.getGauche());
      System.out.print(racine.getElement() + " ");
      parcoursInfixe(racine.getDroit());
    } // if
  } // parcoursInfixe()

  /**
   * Parcours postfixe de l'arbre binaire (GDR).
   *
   * @param racine La racine de l'ABR
   */
  public static void parcoursPostfixe(NoeudABR<String> racine) {
    if (racine != null) {
      parcoursPostfixe(racine.getGauche());
      parcoursPostfixe(racine.getDroit());
      System.out.print(racine.getElement() + " ");
    } // if
  } // parcoursPostfixe()

  /**
   * Insérer un élément dans un ABR.
   *
   * @param element Élément à insérer
   * @param racine  La racine de l'ARB
   * @return ABR
   */
  public static <T extends Comparable> NoeudABR<T> inserer(T element, NoeudABR<T> racine) {
    // Si l'arbre est null
    if (racine == null) {
      return new NoeudABR<T>(element);
    } // if

    // Comparer pour décider ou insérer le nouveau élément
    if (element.compareTo(racine.getElement()) < 0) {
      // Insérer le nouveau élément dans le sous-arbre gauche
      racine.setGauche(inserer(element, racine.getGauche()));
    } else if (element.compareTo(racine.getElement()) > 0) {
      // Insérer le nouveau élément dans le sous-arbre gauche
      racine.setDroit(inserer(element, racine.getDroit()));
    } // else if

    return racine;
  } // inserer()

  /**
   * Calculer la taille de l'arbre binaire.
   *
   * @param racine La racine de l'ABR
   * @return La taille de l'ABR
   */
  public static <T> int taille(NoeudABR<T> racine) {
    int taille = 0;

    // Si l'arbre n'est pas null
    if (racine != null) {
      taille = 1 + taille(racine.getGauche()) // Sous-arbre gauche
          + taille(racine.getDroit()); // Sous-arbre droit
    } // if

    return taille;
  } // taille()

  /**
   * Calculer la hauteur de l'ABR donne par racine.
   *
   * @param racine racine La racine de l'ABR
   * @return la hauteur de l'ABR ou -1 si racine est null.
   */
  public static <T> int hauteur(NoeudABR<T> racine) {
    int hauteur = -1;

    if (racine != null) {
      hauteur = 1 + Math.max(hauteur(racine.getGauche()), hauteur(racine.getDroit()));
    } // if

    return hauteur;
  } // hauteur()

} // ArbreBinaireDemo