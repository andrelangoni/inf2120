package abr;

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
    if (_element != null) {
      int direction = element.compareTo(_element);
      if (direction <= 0) {
        _gauche = (_gauche == null) ? new ABR<>(element) : _gauche.inserer(element);
      } else if (direction > 0) {
        _droite = (_droite == null) ? new ABR<>(element) : _droite.inserer(element);
      } // else if
    } else {
      _element = element;
    } // else
    return this;
  } // inserer()

  public int taille() {
    return 1 + ((_gauche == null) ? 0 : _gauche.taille()) +
        ((_droite == null) ? 0 : _droite.taille()) ;
  } // taille()

  /** Affiche les elements en ordre.*/
  public static void parcoursInfixe(ABR racine) {
    if (racine != null) {
      parcoursInfixe(racine._gauche);
      System.out.print(racine._element + " ");
      parcoursInfixe(racine._droite);
    } // if
  } // parcoursInfixe()

  public static void parcoursPrefixe(ABR racine) {
    if (racine != null) {
      System.out.print(racine._element + " ");
      parcoursPrefixe(racine._gauche);
      parcoursPrefixe(racine._droite);
    } // if
  } // parcoursPrefixe()

  public static void parcoursSuffixe(ABR racine) {
    if (racine != null) {
      parcoursSuffixe(racine._gauche);
      parcoursSuffixe(racine._droite);
      System.out.print(racine._element + " ");
    } // if
  } // parcoursSuffixe()

  public static int hauteur(ABR racine) {
    int hauteur = -1;
    if (racine != null) {
      hauteur = 1 + Math.max(hauteur(racine._gauche), hauteur(racine._droite));
    } // if
    return hauteur;
  } // hauteur()

  public E elementPlusAGauche(ABR<E> racine) {
    return (racine._gauche == null) ? racine._element : elementPlusAGauche(racine._gauche);
  } // elementPlusAGauche()

  public ABR<E> supprimer(ABR<E> racine, E element) {
    ABR<E> resultat = racine;
    int direction = element.compareTo(racine._element);

    if (direction < 0) {
      if (racine._gauche != null) {
        racine._gauche = supprimer(racine._gauche, element);
      } // if
    } else if (direction > 0) {
      if (racine._droite != null) {
        racine._droite = supprimer(racine._droite, element);
      } // if
    } else {
      // supression (quand l'élément est trouvé)
      // 4 cas possibles
      // 2 premier cas (2 null ou gauche est null)
      // le noeud parent est remplacé par le noeud enfant
      if (racine._gauche == null) {
        resultat = racine._droite;
      } else if (racine._droite == null) {
        resultat = racine._gauche;
      } else {
        racine._element = elementPlusAGauche(racine._droite);
        racine._droite = supprimer(racine._droite, racine._element);
      } // else
    } // else

    return resultat;
  } // supprimer()
} // ABR