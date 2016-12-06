package test;

import nombre.NDouble;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NDoubleTest {
  private NDouble n1 = new NDouble(1);
  private NDouble n2 = new NDouble(2);

  @Test
  public void add() throws Exception {
    assertEquals(new NDouble(3), n1.add(n2));
  }

  @Test
  public void sub() throws Exception {
    assertEquals(new NDouble(-1), n1.sub(n2));
  }

  @Test
  public void mul() throws Exception {
    assertEquals(n2, n1.mul(n2));
  }

  @Test
  public void div() throws Exception {
    assertEquals(new NDouble(0.5), n1.div(n2));
  }

  @Test
  public void divParZero() throws Exception {
    assertNull(n1.div(new NDouble(0)));
  }

  @Test
  public void testToString() throws Exception {
    assertEquals("1.0", n1.toString());
  }

}