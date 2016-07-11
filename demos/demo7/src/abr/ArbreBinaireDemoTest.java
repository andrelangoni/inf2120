package abr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArbreBinaireDemoTest {
  private NoeudABR<Integer> racine = new NoeudABR<>(20);

  @Before
  public void setUp() throws Exception {
    // Act
    ArbreBinaireDemo.inserer(10, racine);
    ArbreBinaireDemo.inserer(42, racine);
    ArbreBinaireDemo.inserer(8, racine);
    ArbreBinaireDemo.inserer(5, racine);
    ArbreBinaireDemo.inserer(15, racine);

    ArbreBinaireDemo.inserer(45, racine);
    ArbreBinaireDemo.inserer(47, racine);
    ArbreBinaireDemo.inserer(30, racine);
    ArbreBinaireDemo.inserer(9, racine);
  } // setUp()

  @Test
  public void parcoursPrefixe() throws Exception {
    ArbreBinaireDemo.parcoursPrefixe(racine);
  } // parcoursPrefixe()

  @Test
  public void taille() throws Exception {
    // Assert
    assertEquals(10, ArbreBinaireDemo.taille(racine));
  }

  @Test
  public void hauteur() throws Exception {
    // Assert
    assertEquals(3, ArbreBinaireDemo.hauteur(racine));
  } // hauteur()

} // ArbreBinaireTest