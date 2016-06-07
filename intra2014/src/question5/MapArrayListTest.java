package question5;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ConstantConditions")
public class MapArrayListTest {
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
        boolean expResult = true;
        boolean result = list.estVide();
        assertEquals(expResult, result);
    } // estVide()

    @Test
    public void vider() throws Exception {
        println("vider");
        MapArrayList<Integer, String> list = new MapArrayList<>();
        list.ajouter(0, "zero");
        list.ajouter(3, "trois");
        list.ajouter(1, "un");
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
        String expResult = valeur;
        String result = (String) list.obtenir(cle);
        assertEquals(expResult, result);
    } // obtenir()

    @Test
    public void ajouter() throws Exception {
        println("ajouter");
        MapArrayList<Integer, String> list = new MapArrayList<>();
        boolean expResult = true;
        boolean result = list.ajouter(0, "zero");
        assertEquals(expResult, result);
    } // ajouter()

    @Test
    public void contientCle() throws Exception {
        println("contientCle");
        MapArrayList<Integer, String> list = new MapArrayList<>();
        int cle = 0;
        boolean expResult = true;
        list.ajouter(cle, "zero");
        boolean result = list.contientCle(cle);
        assertEquals(expResult, result);
    } // contientCle()

    @Test
    public void contientValeur() throws Exception {
        println("contientValeur");
        MapArrayList<Integer, String> list = new MapArrayList<>();
        String valeur = "zero";
        boolean expResult = true;
        list.ajouter(0, valeur);
        boolean result = list.contientValeur(valeur);
        assertEquals(expResult, result);
    } // contientValeur()

    @Test
    public void supprimer() throws Exception {
        println("supprimer");
        MapArrayList<Integer, String> list = new MapArrayList<>();
        int cle = 0;
        String valeur = "zero";
        list.ajouter(cle, valeur);
        String result = (String) list.supprimer(cle);
        assertEquals(valeur, result);
        assertEquals(false, list.contientCle(cle));
    } // supprimer()

    public void println(String s) { System.out.println(s); } // println()
} // MapArrayListTest