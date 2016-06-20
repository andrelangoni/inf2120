package question5;

import static org.junit.Assert.assertEquals;

public class MainTest2 {
  @org.junit.Test
  public void existeElement() throws Exception {
    // Arrange
    File<String> f1 = new File<>();

    f1.enfiler("O");
    f1.enfiler("P");
    f1.enfiler("Q");
    f1.enfiler("R");
    f1.enfiler("S");

    // Assert
    assertEquals(true, Main2.existeElement(f1, "Q"));
    assertEquals(false, Main2.existeElement(f1, "Z"));
  } // obtenirLesNegatifs()

} // MainTest