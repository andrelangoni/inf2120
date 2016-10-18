import java.util.Iterator;

class IterListeDC<S> implements Iterator<S> {
  private Noeud<S> courant = null;

  IterListeDC(ListeDC<S> liste) {
    courant = liste.debut;
  } // IterListeDC()

  public boolean hasNext() {
    return null != courant;
  } // hasNext()

  public S next() {
    S element = courant.element;
    courant = courant.suivant;
    return element;
  } // next()
} // IterListeDC