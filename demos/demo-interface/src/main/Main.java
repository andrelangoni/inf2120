package main;

import nombre.Fraction;
import nombre.NDouble;
import nombre.Nombre;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    testNDouble();
    testFraction();
    testSommeNDouble();
    testSommeFraction();
  }

  public static <N extends Nombre<N>> Nombre<N> somme(ArrayList<N> tableau) {
    Nombre<N> somme = null;

    if (!tableau.isEmpty()) {
      somme = tableau.get(0);
      for (int i = 1; i < tableau.size(); ++i) {
        N nombre = tableau.get(i);
        somme = somme.add(nombre);
      }
    }

    return somme;
  }

  private static void testNDouble() {
    NDouble n1 = new NDouble(1);
    NDouble n2 = new NDouble(2);
    System.out.printf("%.3f + %.3f = %.3f\n", n1.getValeur(), n2.getValeur(), n1.add(n2).getValeur());
    System.out.printf("%.3f - %.3f = %.3f\n", n1.getValeur(), n2.getValeur(), n1.sub(n2).getValeur());
    System.out.printf("%.3f * %.3f = %.3f\n", n1.getValeur(), n2.getValeur(), n1.mul(n2).getValeur());
    System.out.printf("%.3f / %.3f = %.3f\n", n1.getValeur(), n2.getValeur(), n1.div(n2).getValeur());
  }

  private static void testFraction() {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(3, 4);
    System.out.println(f1.toString() + " + " + f2.toString() + " = " + f1.add(f2));
    System.out.println(f1.toString() + " - " + f2.toString() + " = " + f1.sub(f2));
    System.out.println(f1.toString() + " * " + f2.toString() + " = " + f1.mul(f2));
    System.out.println(f1.toString() + " / " + f2.toString() + " = " + f1.div(f2));
  }

  private static void testSommeNDouble() {
    String chaine = "Somme de { ";
    ArrayList<NDouble> liste = new ArrayList<>();
    liste.add(new NDouble(1));
    liste.add(new NDouble(2));
    liste.add(new NDouble(3));
    liste.add(new NDouble(4));

    for (NDouble n : liste) {
      chaine += n.toString() + " ";
    }

    chaine += "} = ";
    NDouble somme = (NDouble) somme(liste);
    chaine += somme.getValeur();
    System.out.println(chaine);
  }

  private static void testSommeFraction() {
    String chaine = "Somme de { ";
    ArrayList<Fraction> liste = new ArrayList<>();
    liste.add(new Fraction(1, 2));
    liste.add(new Fraction(3, 4));
    liste.add(new Fraction(5, 8));
    liste.add(new Fraction(6, 16));

    for (Fraction f : liste) {
      chaine += f.toString() + " ";
    }

    chaine += "} = ";
    Fraction somme = (Fraction) somme(liste);
    chaine += somme.toString();
    System.out.println(chaine);
  }
} // Main