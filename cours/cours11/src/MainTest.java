import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
  @org.junit.Test
  public void triRapide() throws Exception {
    Integer[] tableauAtrier = new Integer[]{90, 65, 7, 305, 120, 110, 8};
    Integer[] expected = new Integer[]{7, 8, 65, 90, 110, 120, 305};
    System.out.print(Arrays.toString(tableauAtrier));
    System.out.println();
    Main.triRapide(tableauAtrier);
    System.out.print(Arrays.toString(tableauAtrier));
    assertEquals(Arrays.asList(expected), Arrays.asList(tableauAtrier));
  }

}