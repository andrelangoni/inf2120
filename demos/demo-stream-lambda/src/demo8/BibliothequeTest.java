package demo8;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliothequeTest {
  private Bibliotheque biblio = new Bibliotheque();

  private Livre livre1 = new Livre("A l’ecole des sorciers", "2070643026", 14.00);
  private Livre livre2 = new Livre("La Chambre des secrets", "2070643034", 13.00);
  private Livre livre3 = new Livre("Le Prisonnier d'Azkaban", "2070643042", 25.00);
  private Livre livre4 = new Livre("La Coupe de feu", "2070643050", 20.00);
  private Livre livre5 = new Livre("L'Ordre du phenix", "2070643069", 23.00);
  private Livre livre6 = new Livre("Le Prince de sang-mele", "2070643077", 20.00);
  private  Livre livre7 = new Livre("Les Reliques de la Mort", "2070615367", 5.00);

  private Client harry = new Client("Harry", "Potter", "1");
  private Client ron = new Client("Ron", "Weasley", "2");
  private Client hermione = new Client("Hermione", "Granger", "3");

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    biblio.ajouterLivre(livre1);
    biblio.ajouterLivre(livre2);
    biblio.ajouterLivre(livre3);
    biblio.ajouterLivre(livre4);
    biblio.ajouterLivre(livre5);
    biblio.ajouterLivre(livre6);
    biblio.ajouterLivre(livre7);

    biblio.emprunter(ron, livre6);
    biblio.emprunter(ron, livre2);
    biblio.emprunter(hermione, livre4);
  }

  @Test
  public void estEmprunte() throws Exception {
    assertTrue(biblio.estEmprunte(livre4));
  }

  @Test
  public void estEmprunteFaux() throws Exception {
    assertFalse(biblio.estEmprunte(livre1));
  }

  @Test
  public void nombreEmprunt() throws Exception {
    assertEquals(2, biblio.nombreEmprunt(ron));
  }

  @Test
  public void nombreEmpruntNul() throws Exception {
    assertEquals(0, biblio.nombreEmprunt(harry));
  }

  @Test(expected = LivreDejaEmprunte.class)
  public void emprunterLivreDejaEmprunte() throws Exception {
    biblio.emprunter(harry, livre6);
  }

  @Test(expected = ClientAtteintLimite.class)
  public void emprunterClientAtteintLimite() throws Exception {
    biblio.emprunter(ron, livre1);
    biblio.emprunter(ron, livre3);
    biblio.emprunter(ron, livre5);
    biblio.emprunter(ron, livre7);
  }

  @Test
  public void afficherLivresDisponibles() {
    System.setOut(new PrintStream(outputStream));
    biblio.afficherLivresDisponibles();
    assertEquals("A l’ecole des sorciers " +
                 "Le Prisonnier d'Azkaban " +
                 "L'Ordre du phenix " +
                 "Les Reliques de la Mort ",
                 outputStream.toString());
    System.setOut(null);
  }

  @Test
  public void listeEmprunt() {
    Object[] tab = {livre6, livre2};
    assertArrayEquals(tab, biblio.listeEmprunt(ron));
  }

  @Test
  public void valeurInventaire() {
    assertEquals(120.00, biblio.valeurInventaire(), 0.001);
  }

  @Test
  public void devaloriser() {
    biblio.devaloriser(0.10);
    assertEquals(108.00, biblio.valeurInventaire(), 0.001);
  }
}