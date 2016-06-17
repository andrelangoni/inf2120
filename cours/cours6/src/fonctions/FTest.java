package fonctions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FTest {
    @Test
    public void applique() throws Exception {
        F m = new F();
        int test = 3;
        int expResult = test + 2;
        assertEquals(expResult, (int) m.applique(test));
    }

}