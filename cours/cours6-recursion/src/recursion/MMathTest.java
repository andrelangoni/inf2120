package recursion;

import static org.junit.Assert.*;

public class MMathTest {
  @org.junit.Test
  public void somme() throws Exception {
    int somme = MMath.somme(5);
    assertEquals(15, somme);
  }

  @org.junit.Test
  public void factoriel() throws Exception {
    int fact = MMath.factoriel(3);
    assertEquals(6, fact);
  }

  @org.junit.Test
  public void fibonnaci() throws Exception {
    int fibo = MMath.fibonnaci(3);
    assertEquals(2, fibo);
  }

  @org.junit.Test
  public void hanoi() throws Exception {
    MMath.hanoi(2, 'A', 'C', 'B');
    //MMath.hanoi(3, 'A', 'C', 'B');
  }

}