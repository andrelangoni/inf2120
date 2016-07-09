package abr;


/**
 * Quelques m�thodes sur l'ABR.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Mars 2011
 *          Modifi� en Avril 2014
 */
public class ArbreBinaireQuelquesMethodes {


  /**
   * Parcours pr�fixe de l'arbre binaire (RGD).
   *
   * @param racine La racine de l'ABR
   */
  public static void parcoursPrefixe(NoeudABR<String> racine) {

    if (racine != null) {

      System.out.println(racine.getElement() + " ");
      System.out.println("Gauche de " + racine.getElement());
      parcoursPrefixe(racine.getGauche());
      System.out.println("Droite de " + racine.getElement());
      parcoursPrefixe(racine.getDroit());

    }

  }

  /**
   * Parcours infixe de l'arbre binaire (GRD).
   *
   * @param racine La racine de l'ABR
   */
  public static void parcoursInfixe(NoeudABR<String> racine) {

    if (racine != null) {

      parcoursInfixe(racine.getGauche());
      System.out.print(racine.getElement() + " ");
      parcoursInfixe(racine.getDroit());

    }

  }

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

    }

  }

  /**
   * Ins�rer un �l�ment dans un ABR.
   *
   * @param element �l�ment � ins�rer
   * @param racine  La racine de l'ARB
   * @return ABR
   */
  public static NoeudABR<String> inserer(String element, NoeudABR<String> racine) {

    // Si l'arbre est null
    if (racine == null) {
      return new NoeudABR<String>(element);
    }

    // Comparer pour d�cider ou ins�rer le nouveau �l�ment
    if (element.compareTo(racine.getElement()) < 0) {
      // Ins�rer le nouveau �l�ment dans le sous-arbre gauche
      racine.setGauche(inserer(element, racine.getGauche()));
    } else if (element.compareTo(racine.getElement()) > 0) {
      // Ins�rer le nouveau �l�ment dans le sous-arbre gauche
      racine.setDroit(inserer(element, racine.getDroit()));
    }

    return racine;
  }

  /**
   * Calculer la taille de l'arbre binaire.
   *
   * @param racine La racine de l'ABR
   * @return La taille de l'ABR
   */
  public static int taille(NoeudABR<String> racine) {

    int taille = 0;

    // Si l'arbre n'est pas null
    if (racine != null) {
      taille = 1 + taille(racine.getGauche()) // Sous-arbre gauche
          + taille(racine.getDroit()); // Sous-arbre droit
    }

    return taille;

  }

  /**
   * Calculer la hauteur de l'ABR donne par racine.
   *
   * @param racine racine La racine de l'ABR
   * @return la hauteur de l'ABR ou -1 si racine est null.
   */
  public static int hauteur(NoeudABR<String> racine) {
    int hauteur = -1;

    if (racine != null) {
      hauteur = 1 + Math.max(hauteur(racine.getGauche()), hauteur(racine.getDroit()));
    }
    return hauteur;
  }

}