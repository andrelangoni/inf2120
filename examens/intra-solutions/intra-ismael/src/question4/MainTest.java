package question4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
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
    Pile<Integer> negatifs = Main.obtenirLesNegatifs(p1);

    // Assert
    assertEquals("-9 -7 -3 ", negatifs.toString());
    System.out.println(negatifs.toString());

    assertEquals("-3 2 -7 4 -9 ", p1.toString());
    System.out.println(p1.toString());
  } // obtenirLesNegatifs()

  @Test
  public void obtenirLesNegatifs2() throws Exception {
    // Act
    Pile<Integer> negatifs = Main2.obtenirLesNegatifs(p1);

    // Assert
    assertEquals("-9 -7 -3 ", negatifs.toString());
    System.out.println(negatifs.toString());

    assertEquals("-3 2 -7 4 -9 ", p1.toString());
    System.out.println(p1.toString());
  } // obtenirLesNegatifs()

} // MainTest