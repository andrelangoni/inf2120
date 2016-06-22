package question6;

import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class Pile<E> extends ArrayList<E> {
    public Pile() {
        super();
    } // Pile()

    public E sommet() {
        return get(size() - 1);
    } // sommet()

    public void empiler(E element) {
        add(element);
    } // empiler()

    public E depiler() {
        return remove(size() - 1);
    } // depiler()
} // Pile