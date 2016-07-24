package bruno.abr;

@SuppressWarnings("WeakerAccess")
public class ABR<E extends Comparable<E>> {
  protected E _element;
  protected ABR<E> _gauche;
  protected ABR<E> _droite;

  public ABR() {}

  public ABR(E element) {
    _element = element;
  } // ABR()

  public ABR<E> inserer(E element) {
    int direction = element.compareTo(_element);
    if (direction <= 0) {
      _gauche = (_gauche == null) ? new ABR<>(element) : _gauche.inserer(element);
    } else if (direction > 0) {
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

  public int recherche(ABR<E> arbre, E element) {
    int hauteur = 0; // hauteur de l'element dans l'arbre
    int direction = element.compareTo(arbre._element);

    if (direction < 0) {
      if (arbre._gauche != null) {
        hauteur++;
        hauteur += recherche(arbre._gauche, element);
      } // if
    } else if (direction > 0) {
      if (arbre._droite != null) {
        hauteur++;
        hauteur += recherche(arbre._droite, element);
      } // if
    } //else { l'element est trouve }

    return hauteur;
  } // recherche()
} // ABR