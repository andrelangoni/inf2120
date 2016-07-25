package bruno.abr;

import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class ABR<E extends Comparable<E>> {
  protected E _element;
  protected ABR<E> _gauche;
  protected ABR<E> _droite;

  public ABR(E element) {
    _element = element;
  } // ABR()

  public ABR<E> inserer(E element) {
    int direction = element.compareTo(_element);
    if (direction <= 0) {
      _gauche = (_gauche == null) ? new ABR<>(element) : _gauche.inserer(element);
    } else  {
      _droite = (_droite == null) ? new ABR<>(element) : _droite.inserer(element);
    } // else if
    return this;
  } // inserer()

  public int taille() {
    return 1 + ((_gauche == null) ? 0 : _gauche.taille()) +
        ((_droite == null) ? 0 : _droite.taille()) ;
  } // taille()

  /** Affiche les elements en ordre.*/
  public static void parcoursInfixe(ABR arbre) {
    if (arbre != null) {
      parcoursInfixe(arbre._gauche);
      System.out.print(arbre._element + " ");
      parcoursInfixe(arbre._droite);
    } // if
  } // parcoursInfixe()

  public static void parcoursPrefixe(ABR arbre) {
    if (arbre != null) {
      System.out.print(arbre._element + " ");
      parcoursPrefixe(arbre._gauche);
      parcoursPrefixe(arbre._droite);
    } // if
  } // parcoursPrefixe()

  public static void parcoursSuffixe(ABR arbre) {
    if (arbre != null) {
      parcoursSuffixe(arbre._gauche);
      parcoursSuffixe(arbre._droite);
      System.out.print(arbre._element + " ");
    } // if
  } // parcoursSuffixe()

  public static int hauteur(ABR arbre) {
    int hauteur = -1;
    if (arbre != null) {
      hauteur = 1 + Math.max(hauteur(arbre._gauche), hauteur(arbre._droite));
    } // if
    return hauteur;
  } // hauteur()

  public E elementPlusAGauche(ABR<E> arbre) {
    return (arbre._gauche == null) ? arbre._element : elementPlusAGauche(arbre._gauche);
  } // elementPlusAGauche()

  public ABR<E> supprimer(ABR<E> arbre, E element) {
    ABR<E> resultat = arbre;
    int direction = element.compareTo(arbre._element);

    if (direction < 0) {
      if (arbre._gauche != null) {
        arbre._gauche = supprimer(arbre._gauche, element);
      } // if
    } else if (direction > 0) {
      if (arbre._droite != null) {
        arbre._droite = supprimer(arbre._droite, element);
      } // if
    } else {
      // supression (quand l'élément est trouvé)
      // 4 cas possibles
      // 2 premier cas (2 null ou gauche est null)
      // le noeud parent est remplacé par le noeud enfant
      if (arbre._gauche == null) {
        resultat = arbre._droite;
      } else if (arbre._droite == null) {
        resultat = arbre._gauche;
      } else {
        arbre._element = elementPlusAGauche(arbre._droite);
        arbre._droite = supprimer(arbre._droite, arbre._element);
      } // else
    } // else

    return resultat;
  } // supprimer()

  boolean trouve = true;

  public int recherche(ABR<E> arbre, E element) {
    int hauteur = 0; // hauteur de l'element dans l'arbre
    int direction = element.compareTo(arbre._element);

    if (direction < 0) {
      if (arbre._gauche != null) {
        hauteur++;
        hauteur += recherche(arbre._gauche, element);
      } else {
        trouve = false;
      } // else
    } else if (direction > 0) {
      if (arbre._droite != null) {
        hauteur++;
        hauteur += recherche(arbre._droite, element);
      } else {
        trouve = false;
      } // else
    } // else if

    if (trouve) {
      return hauteur;
    } // if

    return 0;
  } // recherche()

  /** Calcul du nombre de noeuds.*/
  public static int nbNoeuds(ABR arbre) {
    int nombreNoeuds = 0;
    if (arbre != null) {
      nombreNoeuds++;
      nombreNoeuds += nbNoeuds(arbre._gauche);
      nombreNoeuds += nbNoeuds(arbre._droite);
    } // if
    return nombreNoeuds;
  } // nbNoeuds()

  /** Calcul du nombre de feuilles.*/
  public static int nbFeuilles(ABR arbre) {
    int nombreFeuilles = 0;
    if (arbre != null) {
      if ((arbre._gauche == null) && (arbre._droite == null)) {
        nombreFeuilles++;
      } else {
        nombreFeuilles += nbFeuilles(arbre._gauche);
        nombreFeuilles += nbFeuilles(arbre._droite);
      } // else
    } // if
    return nombreFeuilles;
  } // nbFeuilles()

  public static int nbNoeuds1Enfant(ABR arbre) {
    int nbNoeuds = 0;
    if (arbre != null) {
      if ((arbre._gauche == null) && (arbre._droite != null)) {
        nbNoeuds++;
      } else if ((arbre._droite == null) && (arbre._gauche != null)) {
        nbNoeuds++;
      } // else if
      nbNoeuds += nbNoeuds1Enfant(arbre._gauche);
      nbNoeuds += nbNoeuds1Enfant(arbre._droite);
    } // if
    return nbNoeuds;
  } // nbNoeuds1Enfant()

  public static int nbNoeuds2Enfants(ABR arbre) {
    int nbNoeuds = 0;
    if (arbre != null) {
      if ((arbre._gauche != null) && (arbre._droite != null)) {
        nbNoeuds++;
      } // if
      nbNoeuds += nbNoeuds2Enfants(arbre._gauche);
      nbNoeuds += nbNoeuds2Enfants(arbre._droite);
    } // if
    return nbNoeuds;
  } // nbNoeuds2Enfants()

  /* Methode non-efficace - parcours de tous les noeuds de l'arbre**/
  public int nbNoeudsSuperieursOuEgaux(ABR<E> arbre, E element) {
    int nbNoeuds = 0; // hauteur de l'element dans l'arbre
    int direction = element.compareTo(arbre._element);

    if (direction <= 0) {
      nbNoeuds++;
    } // if

    if (arbre._droite != null) {
      nbNoeuds += nbNoeudsSuperieursOuEgaux(arbre._droite, element);
    } // if
    if (arbre._gauche != null) {
      nbNoeuds += nbNoeudsSuperieursOuEgaux(arbre._gauche, element);
    } // if

      return nbNoeuds;
  } // nbNoeudsSuperieursOuEgaux()

  public boolean estABR(ABR<E> arbre) {
    if (arbre._droite != null) {
      return arbre._droite._element.compareTo(arbre._element) >= 0 && estABR(arbre._droite);
    } // if

    if (arbre._gauche != null) {
      return arbre._gauche._element.compareTo(arbre._element) <= 0 && estABR(arbre._gauche);
    } // if

    return true;
  } // estABR()
} // ABR