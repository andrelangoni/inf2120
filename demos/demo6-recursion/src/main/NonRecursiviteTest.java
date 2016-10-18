package main;

import app.NonRecursivite;
import org.junit.Assert;

import static org.junit.Assert.*;

public class NonRecursiviteTest {
  @org.junit.Test
  public void additionner() throws Exception {
    int n = 2;
    int m = 3;
    // Assert
    Assert.assertEquals(n * m, new NonRecursivite().additionner(n, m));
  }

  @org.junit.Test
  public void pgcd() throws Exception {
    int n = 18;
    int m = 24;
    // Assert
    Assert.assertEquals(6, new NonRecursivite().pgcd(n, m));
  }
}