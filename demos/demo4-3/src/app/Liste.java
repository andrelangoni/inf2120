package app;

import service.IListe;

public class Liste implements IListe {
    @Override
    public boolean estVide() {
        return false;
    }

    @Override
    public int taille() {
        return 0;
    }

    @Override
    public Object debut() {
        return null;
    }

    @Override
    public Object fin() {
        return null;
    }

    @Override
    public Object elementPosition(int position) {
        return null;
    }

    @Override
    public void insererDebut(Object element) {

    }

    @Override
    public void insererFin(Object element) {

    }

    @Override
    public void insererPosition(Object element, int position) {

    }

    @Override
    public Object modifierDebut(Object element) {
        return null;
    }

    @Override
    public Object modifierFin(Object element) {
        return null;
    }

    @Override
    public Object modifierPosition(Object element, int position) {
        return null;
    }
}
