import static org.junit.Assert.*;

public class CoursTest {
  @org.junit.Test
  public void recherche() throws Exception {
    // Arrange
    Integer[] tab = {7,12,3,4,5,7,2,4,0,3,11};
    // Act
    int pos1 = Cours.recherche(tab, 3);
    int pos2 = Cours.recherche(tab, 7);
    int pos3 = Cours.recherche(tab, 11);
    // Assert
    assertEquals(2, pos1);
    assertEquals(0, pos2);
    assertEquals(10, pos3);
  } // recherche()

  @org.junit.Test
  public void recherche2() throws Exception {
    // Arrange
    Integer[] tab = {7,12,3,4,5,7,2,4,0,3,11};
    // Act
    int pos1 = Cours.recherche2(tab, 3);
    int pos2 = Cours.recherche2(tab, 7);
    int pos3 = Cours.recherche2(tab, 11);
    // Assert
    assertEquals(2, pos1);
    assertEquals(0, pos2);
    assertEquals(10, pos3);
  } // recherche2()

  @org.junit.Test
  public void rechercheBinaire() throws Exception {
    // Arrange
    int[] tab = {3,4,5,7,11,12,13,14,15,16};
    // Act
    int pos1 = Cours.rechercheBinaire(tab, 3);
    int pos2 = Cours.rechercheBinaire(tab, 11);
    int pos3 = Cours.rechercheBinaire(tab, 12);
    int pos4 = Cours.rechercheBinaire(tab, 16);
    // Assert
    assertEquals(0, pos1);
    assertEquals(4, pos2);
    assertEquals(5, pos3);
    assertEquals(9, pos4);
  } // recherche2()

} // CoursTest