package typeGenerique;

class Rien<T> extends PeutEtre<T> {
  Rien() {}

  public boolean estQQChose() {
    return false;
  } // estQQChose()

  public boolean estRien() {
    return true;
  } // estRien()

  public T qQChose() throws ARien {
    throw new ARien();
  } // qQChose()
} // Rien