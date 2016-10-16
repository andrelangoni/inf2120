package question7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoupleTest {
  private Couple<Entier> couple1;
  @Before
  public void setUp() throws Exception {
    // Arrange
    couple1 = new Couple<>(new Entier(1), new Entier(2));
  }

  @Test
  public void comparer2() throws Exception {
    // Arrange
    Couple<Entier> couple2 = new Couple<>(new Entier(1), new Entier(2));
    // Assert
    assertEquals(Comparable.Ordre.EGAL, couple1.comparer(couple2));
  }

  @Test
  public void comparer3() throws Exception {
    Couple<Entier> couple3 = new Couple<>(new Entier(1), new Entier(3));
    assertEquals(Comparable.Ordre.PLUS_PETIT, couple1.comparer(couple3));
  }

  @Test
  public void comparer4() throws Exception {
    Couple<Entier> couple4 = new Couple<>(new Entier(1), new Entier(1));
    assertEquals(Comparable.Ordre.PLUS_GRAND, couple1.comparer(couple4));
  }

  @Test
  public void comparer5() throws Exception {
    Couple<Entier> couple5 = new Couple<>(new Entier(3), new Entier(2));
    assertEquals(Comparable.Ordre.PLUS_PETIT, couple1.comparer(couple5));
  }

  @Test
  public void comparer6() throws Exception {
    Couple<Entier> couple6 = new Couple<>(new Entier(0), new Entier(2));
    // Assert
    assertEquals(Comparable.Ordre.PLUS_GRAND, couple1.comparer(couple6));
  }
}