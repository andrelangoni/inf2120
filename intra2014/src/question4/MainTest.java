package question4;

import org.junit.Test;
import static org.junit.Assert.*;

@SuppressWarnings({"ConstantConditions", "WeakerAccess"})
public class MainTest {
    @Test
    public void estPalindrome() throws Exception {
        println("estPalindrome");
        boolean expResult = true;
        boolean result = Main.estPalindrome("laval");
        assertEquals(expResult, result);
    } // estPalindrome()

    @Test
    public void estPalindrome2() throws Exception {
        println("estPalindrome2");
        boolean expResult = false;
        boolean result = Main.estPalindrome("bonjour");
        assertEquals(expResult, result);
    } // estPalindrome()

    @Test
    public void estPalindrome3() throws Exception {
        println("estPalindrome3");
        boolean expResult = false;
        boolean result = Main.estPalindrome("lavwal");
        assertEquals(expResult, result);
    } // estPalindrome()

    @Test
    public void supprimer() throws Exception {
        println("supprimer");
        File<Integer> file = new File<>();
        int element = 1;

        file.enfiler(2);
        file.enfiler(element);
        file.enfiler(-3);
        file.enfiler(element);

        file.enfiler(0);
        file.enfiler(2);
        file.enfiler(8);
        file.enfiler(-3);

        int expResult = file.taille() - 2;
        Main.supprimer(file, element);
        int result = file.taille();
        assertEquals(expResult, result);
    } // supprimer()

    public void println(String s) { System.out.println(s); } // println()

} // MainTest