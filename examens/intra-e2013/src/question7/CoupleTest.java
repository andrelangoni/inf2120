package question7;

import static org.junit.Assert.*;

public class CoupleTest {
  @org.junit.Test
  public void comparer() throws Exception {
    System.out.println("comparer()");
    // Arrange
    Couple<Entier> couple1 = new Couple<>(new Entier(1), new Entier(2));
    Couple<Entier> couple2 = new Couple<>(new Entier(1), new Entier(2));
    Couple<Entier> couple3 = new Couple<>(new Entier(1), new Entier(3));
    Couple<Entier> couple4 = new Couple<>(new Entier(1), new Entier(1));
    Couple<Entier> couple5 = new Couple<>(new Entier(3), new Entier(2));
    Couple<Entier> couple6 = new Couple<>(new Entier(0), new Entier(2));
    // Assert
    assertEquals(Comparable.Ordre.EGAL, couple1.comparer(couple2));
    assertEquals(Comparable.Ordre.PLUS_PETIT, couple1.comparer(couple3));
    assertEquals(Comparable.Ordre.PLUS_GRAND, couple1.comparer(couple4));
    assertEquals(Comparable.Ordre.PLUS_PETIT, couple1.comparer(couple5));
    assertEquals(Comparable.Ordre.PLUS_GRAND, couple1.comparer(couple6));
  } // comparer()
} // CoupleTest