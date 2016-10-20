package test;

import nombre.Fraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {
  private Fraction f1 = new Fraction(1, 2);
  private Fraction f2 = new Fraction(3, 4);

  @Test
  public void setDenom() throws Exception {
    Fraction fraction = new Fraction();
    fraction.setDenom(0);
    assertEquals(Fraction.DENOM_DEFAUT, fraction.getDenom());
  }

  @Test
  public void add() throws Exception {
    assertEquals(new Fraction(5,4), f1.add(f2));
  }

  @Test
  public void sub() throws Exception {
    assertEquals(new Fraction(-1,4), f1.sub(f2));
  }

  @Test
  public void mul() throws Exception {
    assertEquals(new Fraction(3,8), f1.mul(f2));
  }

  @Test
  public void div() throws Exception {
    assertEquals(new Fraction(2,3), f1.div(f2));
  }

  @Test
  public void testToString() throws Exception {
    assertEquals("1/2", f1.toString());
  }
}