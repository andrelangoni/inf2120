package question6;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest6 {
  @Test
  public void inverserChaine() throws Exception {
    // Arrange
    String chaine = "abc";
    String expected = "cba";
    // Act
    String reverse = Main.inverserChaine(chaine);
    // Assert
    assertEquals(expected, reverse);
  } // inverserChaine()

  @Test
  public void estUnPalindrome() throws Exception {
    // Arrange
    String palindrome = "laval";
    String mot = "laver";
    // Assert
    assertEquals(true, Main.estUnPalindrome(palindrome));
    assertEquals(false, Main.estUnPalindrome(mot));
  } // inverserChaine()

} // MainTest6