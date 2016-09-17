package typeGenerique;

class QQChose<T> extends PeutEtre<T> {
  private T valeur;

  QQChose(T valeur) {
    this.valeur = valeur;
  } // QQChose()

  public boolean estQQChose() {
    return true;
  } // estQQChose()

  public boolean estRien() {
    return false;
  } // estRien()

  public T qQChose() {
    return valeur;
  } // qQChose()
} // QQChose