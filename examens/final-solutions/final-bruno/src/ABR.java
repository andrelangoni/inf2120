public class ABR<K extends Comparable<? super K>, V> {
  private class Noeud<Kn extends Comparable<? super Kn>, Vn> {
    public Kn clef;
    public Vn valeur;
    public Noeud<Kn, Vn> gauche;
    public Noeud<Kn, Vn> droite;
  } // Noeud

  private Noeud<K, V> racine = null;

  public int niveau(K clef) {
    int niveau = 0;

    if ((clef != null) && (racine != null)) {
      int direction = racine.clef.compareTo(clef);

      if (direction == 0) {
        return 1;
      } else if (direction < 0) {
        racine = racine.gauche;
        return 1 + niveau(clef);
      } else {
        racine = racine.droite;
        return 1 + niveau(clef);
      } // else

    } // if

    return niveau;
  } // niveau()
} // ABR