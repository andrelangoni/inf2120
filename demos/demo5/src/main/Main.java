package main;

import app.NonRecursivite;
import app.Recursivite;
import services.IRecursivite;
import services.RecursiviteException;

public class Main {
  public static void main(String[] args) {
    IRecursivite recursivite = new Recursivite();
    IRecursivite nonRecursivite = new NonRecursivite();

    // additionner(int nombre, int nfois)
    try {
      println("1 - Recursive ");
      println("additionner: " + recursivite.additionner(2, 3));

      println("2 - Non Recursive ");
      println("additionner: " + nonRecursivite.additionner(2, 3));
    } catch (RecursiviteException e) {
      println(e.getMessage());
    } // catch
  } // main()

  public static void println(String s) {
    System.out.println(s);
  } // println()
} // Main