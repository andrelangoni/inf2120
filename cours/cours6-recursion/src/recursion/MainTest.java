package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void max() throws Exception {
        int max = 18;
        int[] tab = {7, 2, 11, max, 4, 5};
        int max2 = Main.max(tab);
        assertEquals(max, max2);
    } // max()

} // MainTest