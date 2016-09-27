import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PileTest {
  private Pile<Integer> pile = new Pile<>();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    pile.empiler(3);
    pile.empiler(7);
    pile.empiler(4);
  } // setUp()

  @Test
  public void taille() throws Exception {
    assertEquals(3, pile.taille());
  } // taille()

  @Test
  public void tailleDepiler() throws Exception {
    pile.depiler();
    assertEquals(2, pile.taille());
  } // tailleDepiler()

  @Test
  public void estVide() throws Exception {
    assertEquals(false, pile.estVide());
  } // estVide()

  @Test
  public void estVideDepiler() throws Exception {
    while (!pile.estVide()) {
      pile.depiler();
    } // while
    assertEquals(true, pile.estVide());
  } // estVideDepiler()

  @Test
  public void sommet() throws Exception {
    assertEquals(new Integer(4), pile.sommet());
  } // sommet()

  @Test(expected = PileVide.class)
  public void sommetPileVide() throws Exception {
    while (!pile.estVide()) {
      pile.depiler();
    } // while

    pile.sommet();
  } // sommetPileVide()

  @Test
  public void empiler() throws Exception {
    pile.empiler(1);
    assertEquals(new Integer(1), pile.sommet());
  } // empiler()

  @Test
  public void depiler() throws Exception {
    pile.depiler();
    assertEquals(new Integer(7), pile.sommet());
  } // depiler()

  @Test(expected = PileVide.class)
  public void depilerPileVide() throws Exception {
    while (!pile.estVide()) {
      pile.depiler();
    } // while

    pile.depiler();
  } // depilerPileVide()

} // PileTest