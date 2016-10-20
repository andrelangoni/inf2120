package test;

import main.Main;
import nombre.Fraction;
import nombre.NDouble;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void sommeNDouble() throws Exception {
    ArrayList<NDouble> liste = new ArrayList<>();
    liste.add(new NDouble(1));
    liste.add(new NDouble(2));
    liste.add(new NDouble(3));
    liste.add(new NDouble(4));
    assertEquals(new NDouble(10), Main.somme(liste));
  }

  @Test
  public void sommeFraction() throws Exception {
    ArrayList<Fraction> liste = new ArrayList<>();
    liste.add(new Fraction(1, 2));
    liste.add(new Fraction(3, 4));
    liste.add(new Fraction(5, 8));
    liste.add(new Fraction(6, 16));
    assertEquals(new Fraction(9, 4), Main.somme(liste));
  }

}