package typeGenerique;

abstract class PeutEtre<T> {
  // Methodes abstraites
  public abstract boolean estQQChose();

  public abstract boolean estRien();

  public abstract T qQChose() throws ARien;
} // PeutEtre