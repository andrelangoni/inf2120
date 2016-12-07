package bruno.abr;

import bruno.test.ABR2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

  @Test
  public void recherche() throws Exception {
    System.out.println("recherche()");
    assertEquals(0, racine.recherche(racine, "nappe"));
    assertEquals(5, racine.recherche(racine, "couche"));
    assertEquals(4, racine.recherche(racine, "manchot"));
    assertEquals(3, racine.recherche(racine, "serpent"));
    assertEquals(3, racine.recherche(racine, "lune"));
    assertEquals(0, racine.recherche(racine, "introuvable"));
  } // recherche()

  @Test
  public void nbNoeuds() throws Exception {
    System.out.println("nbNoeuds()");
    assertEquals(10, ABR.nbNoeuds(racine));
  } // nbNoeuds()

  @Test
  public void nbFeuilles() throws Exception {
    System.out.println("nbFeuilles()");
    assertEquals(3, ABR.nbFeuilles(racine));
  } // nbFeuilles()

  @Test
  public void nbNoeuds1Enfant() throws Exception {
    System.out.println("nbNoeuds1Enfant()");
    assertEquals(5, ABR.nbNoeuds1Enfant(racine));
  } //nbNoeuds1Enfant()

  @Test
  public void nbNoeuds2Enfants() throws Exception {
    System.out.println("nbNoeuds2Enfants()");
    assertEquals(2, ABR.nbNoeuds2Enfants(racine));
  } // nbNoeuds2Enfants()

  @Test
  public void nbNoeudsSuperieursOuEgaux() throws Exception {
    System.out.println("nbNoeudsSuperieursOuEgaux()");
    assertEquals(4, racine.nbNoeudsSuperieursOuEgaux(racine, "nappe"));
    assertEquals(6, racine.nbNoeudsSuperieursOuEgaux(racine, "lune"));
    assertEquals(8, racine.nbNoeudsSuperieursOuEgaux(racine, "couche"));
    assertEquals(10, racine.nbNoeudsSuperieursOuEgaux(racine, "balle"));
    assertEquals(1, racine.nbNoeudsSuperieursOuEgaux(racine, "tarte"));
    assertEquals(10, racine.nbNoeudsSuperieursOuEgaux(racine, "arbre"));
    assertEquals(0, racine.nbNoeudsSuperieursOuEgaux(racine, "zoo"));
  } // nbNoeudsSuperieursOuEgaux()

  @Test
  public void nbNoeudsAvecPrefixe() throws Exception {
    System.out.println("nbNoeudsAvecPrefixe()");
    assertEquals(2, ABR.nbNoeudsAvecPrefixe(racine, "b"));
    assertEquals(1, ABR.nbNoeudsAvecPrefixe(racine, "s"));
    assertEquals(0, ABR.nbNoeudsAvecPrefixe(racine, "a"));
  } // nbNoeudsAvecPrefixe()

  @Test
  public void estABR() throws Exception {
    System.out.println("estABR()");
    assertTrue(racine.estABR(racine));

    ABR2<String> arbre = new ABR2<>("A");
    arbre._gauche = new ABR2<>("B");
    arbre._droite = new ABR2<>("C");
    assertFalse(arbre.estABR(arbre));

    ABR2<String> arbre2 = new ABR2<>("C");
    arbre2._gauche = new ABR2<>("A");
    arbre2._droite = new ABR2<>("B");
    assertFalse(arbre2.estABR(arbre2));

    ABR2<String> arbre3 = new ABR2<>("C");
    ABR2<String> arbre4 = new ABR2<>("B");
    arbre4._gauche = new ABR2<>("A");
    arbre3._gauche = arbre4;
    ABR2<String> arbre5 = new ABR2<>("E");
    arbre3._droite = arbre5;
    arbre5._droite = new ABR2<>("D");
    assertFalse(arbre3.estABR(arbre3));
  } // estABR()
} // TestABR