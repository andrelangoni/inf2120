package service;

public class Maillon<T> {
    private T element;
    private Maillon<T> suivant;

    // Maillon avec null comme suivant
    public Maillon(T elem) {
        this(elem, null);
    }

    public Maillon(T elem, Maillon<T> suivant) {
        element = elem;
        this.suivant = suivant;
    }

    public T getElement() {
        return element;
    }

    public Maillon<T> getSuivant() {
        return suivant;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setSuivant(Maillon<T> suivant) {
        this.suivant = suivant;
    }
} // Maillon