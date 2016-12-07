public interface Ord<T> extends EqInterface<T> {
    Ordering compare(T x);

    default boolean plusPetitQue(T x) {
        return compare(x) == Ordering.LT;
    };

    default boolean plusPetitEgal(T x) {
        return compare(x) != Ordering.GT;
    }

    default boolean plusGrandQue(T x) {
        return compare(x) == Ordering.GT;
    }

    default boolean plusGrandEgal(T x) {
        return compare(x) != Ordering.LT;
    }
}
