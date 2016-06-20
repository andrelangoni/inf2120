package main;

import app.Recursivite;
import org.junit.Assert;

import static org.junit.Assert.*;

public class RecursiviteTest {
  @org.junit.Test
  public void additionner() throws Exception {
    int n = 2;
    int m = 3;
    // Assert
    Assert.assertEquals(n * m, new Recursivite().additionner(n, m));
  } // additionner()

  @org.junit.Test
  public void pgcd() throws Exception {
    int n = 18;
    int m = 24;
    // Assert
    Assert.assertEquals(6, new Recursivite().pgcd(n, m));
  } // pgcd()

} // RecursiviteTest