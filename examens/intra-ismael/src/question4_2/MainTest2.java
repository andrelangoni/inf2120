package question4_2;

import static org.junit.Assert.assertEquals;

public class MainTest2 {
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
    negatifs = Main2.obtenirLesNegatifs(p1);
    // Assert
    assertEquals(negatifs.size(), 3);
    assertEquals(p1.size(), 5);
  } // obtenirLesNegatifs()

} // MainTest