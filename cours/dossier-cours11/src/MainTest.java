import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
  @org.junit.Test
  public void triRapide() throws Exception {
    Integer[] tableauAtrier = new Integer[]{96, 64, 6, 78, 22, 30, 20};
    Integer[] expected = new Integer[]{6, 20, 22, 30, 64, 78, 96};
    System.out.println(Arrays.toString(tableauAtrier));
    Main.triRapide(tableauAtrier);
    System.out.print(Arrays.toString(tableauAtrier));
    assertEquals(Arrays.asList(expected), Arrays.asList(tableauAtrier));
  }

}