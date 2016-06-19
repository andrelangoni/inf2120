package question5;

import java.util.ArrayList;

public class Main {
  static ArrayList<Character> liste = new ArrayList<Character>();

  public static void main(String[] args) {
    String code = "FRAC12089201";
    liste.add(code.charAt(2));
    print();
    liste.add(0,code.charAt(3));
    print();
    liste.add(2,code.charAt(0));
    print();
    liste.set(1,'*');
    print();
    liste.add(code.charAt(5));
    print();
    liste.add(2,code.charAt(7));
    print();
    liste.remove((Character)'A');
    print();
    liste.add(liste.remove(0));
    print();
    liste.set(2,liste.get(2));
    print();
    liste.add(liste.indexOf('D')+1,code.charAt(7));
    print();
  }

  public static void print() {
    for (Character c : liste) {
      System.out.print(String.valueOf(c));
    } // for
    System.out.println();
  }
}
