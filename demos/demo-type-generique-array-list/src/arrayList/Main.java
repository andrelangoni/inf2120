package arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    testTweens(1.0, 3.0, 4);
    System.out.println();
    testTweens2(2, 4, 8);
  }

  private static ArrayList<Double> tweens(double depart, double fin, int nbrInterval) {
    double taille = nbrInterval + 1;
    ArrayList<Double> liste = new ArrayList<>(nbrInterval + 1);
    double pas = (fin - depart) / nbrInterval;
    double nombre = depart;

    for (int i = 0; i < taille; ++i) {
      liste.add(nombre);
      nombre += pas;
    }

    return liste;
  }

  private static void testTweens(double depart, double fin, int nbrInterval) {
    ArrayList<Double> liste = tweens(depart, fin, nbrInterval);
    for (Double nombre : liste) {
      System.out.print(String.valueOf(nombre) + " ");
    }
  }

  private static void testTweens2(double depart, double fin, int nbrInterval) {
    ArrayList<Double> liste = tweens(depart, fin, nbrInterval);

    Iterator<Double> iterator = liste.iterator();

    while (iterator.hasNext()) {
      System.out.print(String.valueOf(iterator.next()) + " ");
    }
  }
} // Main