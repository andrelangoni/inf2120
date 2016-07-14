package abr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArbreBinaireQuelquesMethodesTest {
  private NoeudABR<String> racine = new NoeudABR<>("nappe");

  @Before
  public void setUp() throws Exception {
    // Arrange
    // Act
    ArbreBinaireQuelquesMethodes.inserer("balle", racine);
    ArbreBinaireQuelquesMethodes.inserer("tarte", racine);
    ArbreBinaireQuelquesMethodes.inserer("bleu", racine);
    ArbreBinaireQuelquesMethodes.inserer("lune", racine);
    ArbreBinaireQuelquesMethodes.inserer("goupille", racine);

    ArbreBinaireQuelquesMethodes.inserer("oignon", racine);
    ArbreBinaireQuelquesMethodes.inserer("serpent", racine);
    ArbreBinaireQuelquesMethodes.inserer("couche", racine);
    ArbreBinaireQuelquesMethodes.inserer("manchot", racine);
  } // setUp()

  /*
  @Test
  public void parcoursPrefixe() throws Exception {
    System.out.println("parcoursPrefixe()");
    ArbreBinaireQuelquesMethodes.parcoursPrefixe(racine);
  } // parcoursPrefixe()
  */

  @Test
  public void parcoursInfixe() throws Exception {
    System.out.println("parcoursInfixe()");
    ArbreBinaireQuelquesMethodes.parcoursInfixe(racine);
  } // parcoursPrefixe()

  @Test
  public void taille() throws Exception {
    // Assert
    assertEquals(10, ArbreBinaireQuelquesMethodes.taille(racine));
  }

  @Test
  public void hauteur() throws Exception {
    // Assert
    assertEquals(5, ArbreBinaireQuelquesMethodes.hauteur(racine));
  } // hauteur()

  @Test
  public void supprimer() throws Exception {
    // Assert
    String element = "serpent";
    System.out.println("supprimer() " + element);
    ArbreBinaireQuelquesMethodes.supprimer(racine, element);
    assertEquals(9, ArbreBinaireQuelquesMethodes.taille(racine));
    ArbreBinaireQuelquesMethodes.parcoursInfixe(racine);
    System.out.println();
  } // hauteur()

} // ArbreBinaireQuelquesMethodesTest