package bruno.recherche;

import static org.junit.Assert.assertEquals;

public class CoursTest {
  private Cours<Integer> cours = new Cours<>();

  @org.junit.Test
  public void recherche() throws Exception {
    // Arrange
    Integer[] tab = {7,12,3,4,5,7,2,4,0,3,11};
    // Act
    int pos1 = cours.recherche(tab, 3);
    int pos2 = cours.recherche(tab, 7);
    int pos3 = cours.recherche(tab, 11);
    int pos4 = cours.recherche(tab, 20);
    // Assert
    assertEquals(2, pos1);
    assertEquals(0, pos2);
    assertEquals(10, pos3);
    assertEquals(Cours.DEFAUT, pos4);
  } // recherche()

  @org.junit.Test
  public void recherche2() throws Exception {
    // Arrange
    Integer[] tab = {7,12,3,4,5,7,2,4,0,3,11};
    // Act
    int pos1 = cours.recherche2(tab, 3);
    int pos2 = cours.recherche2(tab, 7);
    int pos3 = cours.recherche2(tab, 11);
    int pos4 = cours.recherche(tab, 20);
    // Assert
    assertEquals(2, pos1);
    assertEquals(0, pos2);
    assertEquals(10, pos3);
    assertEquals(Cours.DEFAUT, pos4);
  } // recherche2()

  @org.junit.Test
  public void rechercheBinaire() throws Exception {
    // Arrange
    Integer[] tab = {3,4,5,7,11,12,13,14,15,16};
    // Act
    int pos1 = cours.rechercheBinaire(tab, 3);
    int pos2 = cours.rechercheBinaire(tab, 11);
    int pos3 = cours.rechercheBinaire(tab, 12);
    int pos4 = cours.rechercheBinaire(tab, 16);
    int pos5 = cours.recherche(tab, 20);
    // Assert
    assertEquals(0, pos1);
    assertEquals(4, pos2);
    assertEquals(5, pos3);
    assertEquals(9, pos4);
    assertEquals(Cours.DEFAUT, pos5);
  } // recherche2()

} // CoursTest