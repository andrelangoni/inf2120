package main;

import app.Recursivite;

import static org.junit.Assert.assertEquals;

public class RecursiviteTest {
  @org.junit.Test
  public void additionner() throws Exception {
    int n = 2;
    int m = 3;
    // Assert
    assertEquals(n * m, new Recursivite().additionner(n, m));
  } // additionner()

  @org.junit.Test
  public void pgcd() throws Exception {
    int n = 18;
    int m = 24;
    // Assert
    assertEquals(6, new Recursivite().pgcd(n, m));
  } // pgcd()

} // RecursiviteTest