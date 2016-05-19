public interface EqInterface<T> {
    boolean sontEgaux(T a_element);
    // default : ecrire du code au cas ou la personne necrit pas de code
    default boolean neSontPasEgaux(T a_element) {
        return !sontEgaux(a_element);
    };
}
