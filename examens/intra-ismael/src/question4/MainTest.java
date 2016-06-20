package question4;

import static org.junit.Assert.*;

public class MainTest {
  @org.junit.Test
  public void obtenirLesNegatifs() throws Exception {
    // Arrange
    Pile<Integer> p1 = new Pile<>();
    Pile<Integer> negatifs;

    p1.empiler(-9);
    p1.empiler(4);
    p1.empiler(-7);
    p1.empiler(2);
    p1.empiler(-3);

    // Act
    negatifs = Main.obtenirLesNegatifs(p1);
    // Assert
    assertEquals(negatifs.taille(), 3);
    assertEquals(p1.taille(), 5);
  } // obtenirLesNegatifs()

} // MainTest