package question6;

import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class File<E> extends ArrayList<E> {
    public File() { super(); }

    // l'element au debut de la file
    public E tete() {
      // reste validation
      assert !isEmpty();
      return get(0);
    }

    // ajouter l'element a la fin de la file
    public void enfiler(E element) { add(element); }

    // enlever l'element au debut de la file
    public E defiler() {
      return remove(0);
    }
} // File