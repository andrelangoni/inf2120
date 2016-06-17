public class File<E> {
    private int _taille = 0;
    private Noeud<E> tete = null; // pile vide

    public File() {}

    public int taille() { return _taille; }

    public boolean estVide() {
        return tete == null;
    }

    public E tete() throws FileVide {
        if (estVide()) {
            throw new FileVide();
        } // if
        return tete.element;
    } // tete()

    public void enfiler(E a_element) {
        Noeud<E> noeudCourant = tete;
        Noeud<E> noeudPrecedent = tete;

        while (noeudCourant != null) {
            noeudPrecedent = noeudCourant;
            noeudCourant = noeudCourant.precedent;
        } // while()

        noeudCourant = new Noeud<>(a_element, noeudPrecedent);

        ++_taille;
    } // enfiler()

    public void defiler() throws FileVide {
        if (estVide()) {
            throw new FileVide();
        } // if
        tete = tete.precedent;
        --_taille;
    } // defiler()

    private class Noeud<E> { // private
        public E element;
        public Noeud<E> precedent;

        public Noeud(E element, Noeud<E> precedent) {
            this.element = element;
            this.precedent = precedent;
        }
    }
} // Pile
