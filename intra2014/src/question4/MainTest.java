package question4;

import static org.junit.Assert.*;

@SuppressWarnings({"ConstantConditions", "WeakerAccess"})
public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void estPalindrome() throws Exception {
        println("estPalindrome");
        boolean expResult = true;
        boolean result = Main.estPalindrome("laval");
        assertEquals(expResult, result);
    } // estPalindrome()

    @org.junit.Test
    public void estPalindrome2() throws Exception {
        println("estPalindrome2");
        boolean expResult = false;
        boolean result = Main.estPalindrome("bonjour");
        assertEquals(expResult, result);
    } // estPalindrome()

    @org.junit.Test
    public void estPalindrome3() throws Exception {
        println("estPalindrome3");
        boolean expResult = false;
        boolean result = Main.estPalindrome("lavwal");
        assertEquals(expResult, result);
    } // estPalindrome()

    public void println(String s) { System.out.println(s); } // println()

} // MainTest