package demo8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliothequeTest {
  Bibliotheque biblio = new Bibliotheque();

  Livre livre1 = new Livre("A l’ecole des sorciers", "2070643026", 13.46);
  Livre livre2 = new Livre("La Chambre des secrets", "2070643034", 12.94);
  Livre livre3 = new Livre("Le Prisonnier d'Azkaban", "2070643042", 25.00);
  Livre livre4 = new Livre("La Coupe de feu", "2070643050", 19.76);
  Livre livre5 = new Livre("L'Ordre du phenix", "2070643069", 22.46);
  Livre livre6 = new Livre("Le Prince de sang-mele", "2070643077", 19.76);
  Livre livre7 = new Livre("Les Reliques de la Mort", "2070615367", 3.82);

  Client harry = new Client("Harry", "Potter", "1");
  Client ron = new Client("Ron", "Weasley", "2");
  Client hermione = new Client("Hermione", "Granger", "3");

  @Before
  public void setUp() throws Exception {
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
}