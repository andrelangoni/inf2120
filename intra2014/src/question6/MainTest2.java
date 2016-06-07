package question6;

import org.junit.Test;
import question4.File;

import static org.junit.Assert.*;

public class MainTest2 {
    @Test
    public void inverser() throws Exception {
        println("inverser");
        File<Integer> file = new File<>();

        file.enfiler(1);
        file.enfiler(2);
        file.enfiler(3);

        int expResult = file.taille();
        int expResult2 = file.tete();
        Main2.inverser(file);

        int result2 = file.trouverElement(file.taille());
        assertEquals(expResult2, result2);

        int result = file.taille();
        assertEquals(expResult, result);
    } // inverser()

    public void println(String s) { System.out.println(s); } // println()
} // MainTest2