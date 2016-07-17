package bruno.abr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestABR {
  private ABR<String> racine = new ABR<>("nappe");

  @Before
  public void setUp() throws Exception {
    // Arrange
    // Act
    racine.inserer("balle");
    racine.inserer("tarte");
    racine.inserer("bleu");
    racine.inserer("lune");
    racine.inserer("goupille");

    racine.inserer("oignon");
    racine.inserer("serpent");
    racine.inserer("couche");
    racine.inserer("manchot");
  } // setUp()

  @Test
  public void parcoursInfixe() throws Exception {
    System.out.println("parcoursInfixe()");
    ABR.parcoursInfixe(racine);
  } // parcoursPrefixe()

  @Test public void taille() throws Exception { assertEquals(10, racine.taille()); }

  @Test public void hauteur() throws Exception { assertEquals(5, ABR.hauteur(racine)); }

  @Test
  public void supprimer() throws Exception {
    // Assert
    String element = "serpent";
    System.out.println("supprimer() " + element);
    racine.supprimer(racine, element);
    assertEquals(9, racine.taille());
    ABR.parcoursInfixe(racine);
    System.out.println();
  } // supprimer()

} // racineTest