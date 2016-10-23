package question4_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest2 {
  private Pile<Integer> p1 = new Pile<>();

  @Before
  public void setUp() throws Exception {
    // Arrange
    p1.empiler(-9);
    p1.empiler(4);
    p1.empiler(-7);
    p1.empiler(2);
    p1.empiler(-3);
  }

  @Test
  public void obtenirLesNegatifs() throws Exception {
    // Act
    Pile<Integer> negatifs = Main3.obtenirLesNegatifs(p1);

    // Assert
    assertEquals("[-9, -7, -3]", negatifs.toString());
    System.out.println(negatifs.toString());

    assertEquals("[-9, 4, -7, 2, -3]", p1.toString());
    System.out.println(p1.toString());
  } // obtenirLesNegatifs()

} // MainTest