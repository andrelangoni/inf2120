package question7;

@SuppressWarnings("WeakerAccess")
public interface Comparable {
  @SuppressWarnings("UnnecessaryInterfaceModifier")
  public enum Ordre {PLUS_PETIT, EGAL, PLUS_GRAND}

  Ordre comparer(Comparable v2);
}
