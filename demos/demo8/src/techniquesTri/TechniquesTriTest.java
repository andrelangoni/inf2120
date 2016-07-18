package techniquesTri;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TechniquesTriTest {
  private TechniquesTri<Integer> tri = new TechniquesTri<>();
  private Integer[] tab = {12, 4, 7, 3, 6, 8, 2, 10, 9};

  @Test
  public void triSelection() throws Exception {
    println("triSelection() - debut");
    println(Arrays.asList(tab));
    tri.triSelection(tab);
  } // triSelection()

  @Test
  public void triABulles() throws Exception {
    println("triABulles() - debut");
    println(Arrays.asList(tab));
    tri.triABulles(tab);
  } // triABulles()

  @Test
  public void triInsertion() throws Exception {
    println("triInsertion() - debut");
    println(Arrays.asList(tab));
    tri.triInsertion(tab);
  } // triInsertion()

  private void println(Object o) {
    System.out.println(o);
  } // println()

} // TechniquesTriTest