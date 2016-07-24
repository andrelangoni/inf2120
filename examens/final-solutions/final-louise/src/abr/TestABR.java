package abr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestABR {
  private ABR<Integer> racine = new ABR<>(25);
  private Integer[] tab = {39, 30, 17, 10, 15, 27, 100, 12, 5, 37, 200, 35, 34};

  @Before
  public void setUp() throws Exception {
    // Arrange
    // Act
    for (Integer i : tab) {
      racine.inserer(i);
    } // for
    System.out.println("setUp()");
  } // setUp()

  @Test
  public void parcoursPrefixe() throws Exception {
    System.out.println("parcoursPrefixe()");
    ABR.parcoursPrefixe(racine);
  } // parcoursPrefixe()

  @Test
  public void parcoursInfixe() throws Exception {
    System.out.println("parcoursInfixe()");
    ABR.parcoursInfixe(racine);
  } // parcoursInfixe()

  @Test
  public void parcoursSuffixe() throws Exception {
    System.out.println("parcoursSuffixe()");
    ABR.parcoursSuffixe(racine);
  } // parcoursSuffixe()

  @Test public void taille() throws Exception { assertEquals(14, racine.taille()); }

  @Test public void hauteur() throws Exception { assertEquals(5, ABR.hauteur(racine)); }

/*  @Test
  public void supprimer() throws Exception {
    // Assert
    String element = "serpent";
    System.out.println("supprimer() " + element);
    racine.supprimer(racine, element);
    assertEquals(9, racine.taille());
    ABR.parcoursInfixe(racine);
    System.out.println();
  } // supprimer()*/

  @Test
  public void recherche() throws Exception {
    Integer nombre = 34;
    System.out.println("recherche() de " + String.valueOf(nombre));
    assertEquals(5, racine.recherche(racine, nombre));

    Integer nombre2 = 155;
    System.out.println("\nrecherche() de " + String.valueOf(nombre2));
    try {
      racine.recherche(racine, nombre2);
    } catch (ElementIntrouvableException e) {
      System.out.println("\n" + e.getMessage());
    } // catch
  } // recherche()
} // racineTest