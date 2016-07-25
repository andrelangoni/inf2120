package charles;

public class ABR<K extends Comparable<? super K>, V> {
  private class Noeud<Kn extends Comparable<? super Kn>, Vn> {
    public Kn clef;
    public Vn valeur;
    public Noeud<Kn, Vn> gauche;
    public Noeud<Kn, Vn> droite;

    public Noeud(Kn clef, Vn valeur) {
      this.clef = clef;
      this.valeur = valeur;
    } // Noeud()
  } // Noeud

  public Noeud<K, V> racine = null;
  private boolean trouve = true;

  public int niveau(K clef, Noeud<K, V> noeud) {
    int niveau = 0;

    if (clef != null) {
      int direction = clef.compareTo(noeud.clef);

      if (direction < 0) {
        if (noeud.gauche != null) {
          niveau++;
          niveau += niveau(clef, noeud.gauche);
        } else {
          trouve = false;
        } // else
      } else if (direction > 0) {
        if (noeud.droite != null) {
          niveau++;
          niveau += niveau(clef, noeud.droite);
        } else {
          trouve = false;
        } // else
      } // else if
    } // if

    if (trouve) {
      return niveau;
    } // if

    return 0;
  } // niveau()

  public Noeud inserer(K clef, V valeur, Noeud<K, V> noeud) {
    int direction = clef.compareTo(noeud.clef);
    if (direction <= 0) {
      noeud.gauche = (noeud.gauche == null) ? new Noeud<>(clef, valeur) : inserer(clef, valeur, noeud.gauche);
    } else {
      noeud.droite = (noeud.droite == null) ? new Noeud<>(clef, valeur) : inserer(clef, valeur, noeud.droite);
    } // else
    return noeud;
  } // inserer()
} // ABR