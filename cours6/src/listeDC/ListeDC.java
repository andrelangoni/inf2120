package listeDC;

import java.util.Iterator;

/** liste doublement chaînée */
public class ListeDC<E> implements Iterable<E> {
    private Noeud _debut = null;
    private Noeud _fin = null;
    private int _taille = 0;

    public ListeDC() {} // listeDC.ListeDC()

    public void ajouter_debut(E element) {
        Noeud<E> noeud = new Noeud<>(element);
        noeud._suivant = _debut;
        _debut = noeud;

        if (_fin == null) {
            _fin = noeud;
        } else {
            // ajout du lien manquant
            noeud._suivant._precedent = noeud;
        } // else

        _taille++;
    } // ajouter_debut()

    public void enlever_debut() {
        // On ne peut pas enlever un élément dans une liste vide
        _debut = _debut._suivant;
        if (_debut == null) {
            _fin = null;
        } else {
            _debut._precedent = null;
        } // if
    } // enlever_debut()

    @Override
    public Iterator<E> iterator() {
        return new IterListeDC<>(this);
    } // iterator()

    public class IterListeDC<E> implements Iterator<E> {
        private Noeud<E> _courant;

        public IterListeDC(ListeDC<E> liste) {
            _courant = _debut;
        }

        @Override
        public boolean hasNext() {
            return _courant == null;
        }

        @Override
        public E next() {
            E element = _courant._element;
            _courant = _courant._suivant;
            return element;
        }
    } // IterListeDC

    private class Noeud<E> {
        // 2 pointeurs cette fois
        Noeud<E> _precedent;
        Noeud<E> _suivant;
        E _element;

        public Noeud(E element) {
            _precedent = null;
            _suivant = null;
            _element = element;
        } // Noeud()
    } // Noeud
} // listeDC.ListeDC