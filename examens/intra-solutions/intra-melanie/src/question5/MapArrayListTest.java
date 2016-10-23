package question5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapArrayListTest {
  MapArrayList<Integer, String> list = new MapArrayList<>();

  @Before
  public void setUp() throws Exception {
    list.ajouter(0, "zero");
    list.ajouter(3, "trois");
    list.ajouter(1, "un");
  }

  @Test
  public void taille() throws Exception {
    println("taille");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    int expResult = 1;
    list.ajouter(0, "zero");
    int result = list.taille();
    assertEquals(expResult, result);
  } // taille()

  @Test
  public void estVide() throws Exception {
    println("estVide");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    assertTrue(list.estVide());
  } // estVide()

  @Test
  public void vider() throws Exception {
    println("vider");
    list.vider();
    int expResult = 0;
    int result = list.taille();
    assertEquals(expResult, result);
  } // vider()

  @Test
  public void obtenir() throws Exception {
    println("obtenir");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    Integer cle = 1;
    String valeur = "un";
    list.ajouter(0, "zero");
    list.ajouter(3, "trois");
    list.ajouter(cle, valeur);
    assertEquals(valeur, list.obtenir(cle));
  } // obtenir()

  @Test
  public void ajouter() throws Exception {
    println("ajouter");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    assertTrue(list.ajouter(0, "zero"));
  } // ajouter()

  @Test
  public void contientCle() throws Exception {
    println("contientCle");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    int cle = 0;
    list.ajouter(cle, "zero");
    assertTrue(list.contientCle(cle));
  } // contientCle()

  @Test
  public void contientValeur() throws Exception {
    println("contientValeur");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    String valeur = "zero";
    list.ajouter(0, valeur);
    assertTrue(list.contientValeur(valeur));
  } // contientValeur()

  @Test
  public void supprimer() throws Exception {
    println("supprimer");
    MapArrayList<Integer, String> list = new MapArrayList<>();
    int cle = 0;
    String valeur = "zero";
    list.ajouter(cle, valeur);
    String result = list.supprimer(cle);
    assertEquals(valeur, result);
    assertEquals(false, list.contientCle(cle));
  } // supprimer()

  @Test
  public void testToString() {
    assertEquals("0 --> zero\n" +
                 "3 --> trois\n" +
                 "1 --> un\n",
                 list.toString());
  } // testToString()

  public void println(String s) {
    System.out.println(s);
  } // println()
} // MapArrayListTest