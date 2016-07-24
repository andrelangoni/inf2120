public class Maillon<T> {
  private T info; // donnée dans le maillon
  private Maillon<T> suiv; // référence vers le maillon suivant

  /**
   * Crée un nouveau maillon n'ayant pas de maillon suivant
   *
   * @param o l'information qui sera stockée dans le maillon
   */
  public Maillon(T o) {
    this(o, null);
  }

  /**
   * Crée un nouveau maillon ayant un autre maillon existant comme suivant
   *
   * @param o       l'information qui sera stockée dans le maillon
   * @param suivant le maillon qui sera le suivant du maillon créé
   */
  public Maillon(T o, Maillon<T> suivant) {
    info = o;
    suiv = suivant;
  }

  public T info() {
    return info;
  }

  public Maillon<T> suivant() {
    return suiv;
  }

  public void modifierInfo(T o) {
    info = o;
  }

  public void modifierSuivant(Maillon<T> suivant) {
    suiv = suivant;
  }

  @Override
  public String toString() {
    return super.toString() + " info = " + info + " suivant = @" + Integer.toHexString(suiv.hashCode());
  } // toString()
} // Maillon