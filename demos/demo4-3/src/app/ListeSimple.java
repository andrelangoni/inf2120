package app;

import service.IListe;
import service.ListeException;
import service.Maillon;

public class ListeSimple<T> implements IListe<T> {
    public Maillon<T> debut;
    public int nbElements;

    public ListeSimple() {
        nbElements = 0;
    } // ListeSimple()

    @Override
    public boolean estVide() {
        return nbElements == 0;
    }

    @Override
    public int taille() {
        return nbElements;
    }

    @Override
    public T debut() {
        return debut.getElement();
        //return elementPosition(0);
    }

    @Override
    public T fin() throws ListeException {
        return elementPosition(nbElements - 1);
    }

    @Override
    public T elementPosition(int position) throws ListeException {
        if ((position < 0) || (position > nbElements)) {
            throw new ListeException("Position invalide");
        } else if (position == 0) {
            return debut.getElement();
        } else {
            Maillon<T> temp = debut;
            for (int i = 0; i < position; ++i) {
                temp = temp.getSuivant();
            } // for

            if (temp != null) {
                return temp.getElement();
            } // if
            return null;
        } // else
    } // elementPosition()

    @Override
    public void insererDebut(T element) throws ListeException {
        insererPosition(element, 0);
    }

    @Override
    public void insererFin(T element) throws ListeException {
        insererPosition(element, nbElements);
    }

    /**
     * @param element l'element d’insertion
     * @param position position d’insertion
     * @throws ListeException si position < 0 || position >= taille
     */
    @Override
    public void insererPosition(T element, int position) throws ListeException {
        if ((position < 0) || (position > nbElements)) {
            throw new ListeException("Position invalide");
        } else if (position == 0) {
            debut = new Maillon<T>(element, null);
            ++nbElements;
        } else {
            Maillon<T> temp = debut;
            for (int i = 0; i < position; ++i) {
                temp = temp.getSuivant();
            } // for

            if (temp != null) {
                temp = new Maillon<T>(element, temp.getSuivant());
            } else {
                temp = new Maillon<T>(element, null);
            } // else

            ++nbElements;
        } // else
    } // insererPosition()

    @Override
    public T modifierDebut(T element) throws ListeException {
        return modifierPosition(element, 0);
    }

    @Override
    public T modifierFin(T element) throws ListeException {
        return modifierPosition(element, nbElements -1);
    }

    @Override
    public T modifierPosition(T element, int position) throws ListeException {
        T elementCourant;

        if ((position < 0) || (position > nbElements)) {
            throw new ListeException("Position invalide");
        } else if (position == 0) {
            elementCourant = debut.getElement();
            debut.setElement(element);
        } else {
            Maillon<T> temp = debut;
            for (int i = 0; i < position; ++i) {
                temp = temp.getSuivant();
            } // for

            elementCourant = temp.getElement();
            temp.setElement(element);

            if (temp != null) {
                temp = new Maillon<T>(element, temp.getSuivant());
            } else {
                temp = new Maillon<T>(element, null);
            } // else

            ++nbElements;
        } // else

        return elementCourant;
    } // modifierPosition()
} // ListeSimple