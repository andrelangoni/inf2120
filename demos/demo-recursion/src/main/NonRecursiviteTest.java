package main;

import app.NonRecursivite;

import static org.junit.Assert.assertEquals;

public class NonRecursiviteTest {
  @org.junit.Test
  public void additionner() throws Exception {
    int n = 2;
    int m = 3;
    // Assert
    assertEquals(n * m, new NonRecursivite().additionner(n, m));
  }

  @org.junit.Test
  public void pgcd() throws Exception {
    int n = 18;
    int m = 24;
    // Assert
    assertEquals(6, new NonRecursivite().pgcd(n, m));
  }
}