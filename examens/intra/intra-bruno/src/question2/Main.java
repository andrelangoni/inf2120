package question2;

public class Main {
  public static void main(String[] args) {
    TableauDecalage tableau = new TableauDecalage(5);
    tableau.assigner(0, 3);
    tableau.assigner(1, 4);
    tableau.assigner(2, 1);
    tableau.assigner(3, 6);
    tableau.assigner(4, 5);
    println("tableau avant decalage:");
    tableau.print();
    tableau.decalageGauche(2, 8);
    println("tableau apres decalage:");
    tableau.print();
  } // main()

  private static void println(Object o) {
    System.out.println(o);
  } // println()
} // Main
