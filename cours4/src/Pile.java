public class Pile<E> {
    private int _taille = 0;
    private Noeud<E> _sommet = null; // pile vide

    public Pile() {}

    public int taille() { return _taille; }

    public boolean estVide() {
        return _sommet == null;
    }

    public E sommet() throws PileVide {
        //_sommet.precedent.element
/*        Noeud<E> t = _sommet;
        for (int i = 0; i < 12; ++i) {
            t = t.precedent;
        }*/
        if (estVide()) {
            throw new PileVide();
        } // if
        return _sommet.element;
    }

    public void empiler(E a_element) {
        _sommet = new Noeud<E>(a_element, _sommet);
        ++_taille;
    }

    public void depiler() throws PileVide {
        if (estVide()) {
            throw new PileVide();
        }
        _sommet = _sommet.precedent;
        --_taille;
    }

    private class Noeud<E> { // private
        public E element;
        public Noeud<E> precedent;

        public Noeud(E element, Noeud<E> precedent) {
            this.element = element;
            this.precedent = precedent;
        }
    }
}
