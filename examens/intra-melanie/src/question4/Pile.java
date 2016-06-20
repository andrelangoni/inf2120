package question4;

public class Pile<E> {
    private int _taille = 0;
    private Noeud<E> _sommet = null; // pile vide

    public Pile() {}

    public int taille() { return _taille; }

    public boolean estVide() {
        return _sommet == null;
    }

    public E sommet() throws PileVide {
        if (estVide()) {
            throw new PileVide();
        } // if
        return _sommet.element;
    } // tete()

    public void empiler(E a_element) {
        _sommet = new Noeud<>(a_element, _sommet);
        ++_taille;
    } // enfiler()

    public E depiler() throws PileVide {
        Noeud<E> noeud = _sommet;

        if (estVide()) {
            throw new PileVide();
        } // if
        _sommet = _sommet.precedent;
        --_taille;

        return noeud.element;
    } // defiler()

/*    public void depiler() throws PileVide {
        if (estVide()) {
            throw new PileVide();
        } // if
        _sommet = _sommet.precedent;
        --_taille;
    } // defiler()*/

    @SuppressWarnings("TypeParameterHidesVisibleType")
    private class Noeud<E> { // private
        public E element;
        public Noeud<E> precedent;

        public Noeud(E element, Noeud<E> precedent) {
            this.element = element;
            this.precedent = precedent;
        }
    } // Noeud
} // Pile
