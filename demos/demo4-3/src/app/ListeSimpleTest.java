package app;

import org.junit.Test;
import service.ListeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListeSimpleTest {
    @Test
    public void estVide() throws ListeException {
        System.out.println("estVide");
        ListeSimple instance = new ListeSimple();
        boolean expResult = true;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
    } // estVide()

    @Test
    public void estNonVide() throws ListeException {
        System.out.println("estNonVide");
        ListeSimple instance = new ListeSimple();
        instance.insererDebut("premier");
        boolean expResult = false;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
    } // estNonVide()

    @Test
    public void taille() throws Exception {
        System.out.println("taille");
        ListeSimple instance = new ListeSimple();
        int expResult = 0;
        int result = instance.taille();
        assertEquals(expResult, result);
    } // taille()

    @Test
    public void debut() throws Exception {
        System.out.println("taille");
        ListeSimple instance = new ListeSimple();
        instance.insererDebut(2);
        Object expectResult = null;
        Object result = instance.debut();
    }

    @Test
    public void fin() throws Exception {
        System.out.println("taille");
        ListeSimple instance = new ListeSimple();
        instance.insererDebut(1);
        instance.insererFin(2);
        Object expResult = 2;
        Object result = instance.fin();
        assertEquals(expResult, result);
    } // fin()

    @Test
    public void elementPosition() throws ListeException {
        System.out.println("elementPosition");
        ListeSimple instance = new ListeSimple<>();
        instance.insererPosition("un", 0);
        Object result = instance.elementPosition(0);
        assertTrue(result.toString().equals("un"));
    }

    @Test
    public void elementPosition2() throws ListeException {
        System.out.println("elementPosition2");
        ListeSimple instance = new ListeSimple<>();
        instance.insererPosition("un", 0);
        instance.insererPosition("deux", 1);
        Object result = instance.elementPosition(1);
        assertTrue(result.toString().equals("deux"));
    }

    @Test
    public void insererDebut() throws Exception {

    }

    @Test
    public void insererFin() throws Exception {

    }

    @Test
    public void insererPosition() throws Exception {
        System.out.println("insererPosition");
        Integer element = 1;
        int position = 0;
        ListeSimple<Integer> instance = new ListeSimple<>();
        instance.insererPosition(element, position);
        assertEquals(element, instance.debut());
    }

    @Test
    public void insererPosition2() throws Exception {
        System.out.println("insererPosition2");
        ListeSimple<Integer> instance = new ListeSimple<>();
        instance.insererPosition(1, 0);
        instance.insererPosition(2, 1);
        Integer result = 1;
        Integer result2 = 2;
        assertEquals(instance.taille(), 2);
        assertEquals(result, instance.debut());
        assertEquals(result2, instance.fin());
    }

    @Test
    public void modifierDebut() throws Exception {

    }

    @Test
    public void modifierFin() throws Exception {

    }

    @Test
    public void modifierPosition() throws Exception {

    }

}