package techniquesTri;

import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TechniquesTriTest {
  private TechniquesTri<Integer> trieuse = new TechniquesTri<Integer>();
  Integer[] tableauAtrier;
  @Before
  public void setUp() throws Exception {
/*    tableauAtrier = new Integer[] {
        50, 17, -5, 39, 63, 55, 103, 99, 60 ,12, 6, 57,77, 8, 81, 50, 26, 82, 7, 90, -13, 11, 63
    };*/
    tableauAtrier = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  } // setUp()

  @org.junit.Test
  public void triSelection() throws Exception {
    System.out.println("**********************************");
    System.out.println("|     Debut Tri selection        |");
    System.out.println("**********************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triSelection(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("**********************************");
    System.out.println("|     Fin Tri selection          |");
    System.out.println("**********************************");
  } // triSelection()

  @org.junit.Test
  public void triABulles() throws Exception {
    System.out.println("***************************************");
    System.out.println("|        Debut Tri à bulles           |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triABulles(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri à bulles            |");
    System.out.println("***************************************");
  } // triABulles()

  @org.junit.Test
  public void triInsertion() throws Exception {
    System.out.println("***************************************");
    System.out.println("|        Debut Tri par insertion      |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triInsertion(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri par insertion       |");
    System.out.println("***************************************");
  } // triInsertion()

  @org.junit.Test
  public void quickSort() throws Exception {
    System.out.println("***************************************");
    System.out.println("|        Debut Tri QuickSort          |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.quickSort(tableauAtrier, 0, tableauAtrier.length - 1);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri QuickSort           |");
    System.out.println("***************************************");
  } // quickSort()

}