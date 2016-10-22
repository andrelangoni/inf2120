
package question7.main;

import question7.application.File;
import question7.application.Pile;
import question7.services.FileVide;
import question7.services.PileVide;

public class Main {

  public static void main(String[] args) {

  }

  /**
   * Retourne une nouvelle pile copie identique à p.
   *
   * @param p pile à copier
   */
  public static Pile copier(Pile p) {
    Pile inverse = copierInverse(p);
    return copierInverse(inverse);
  }

  /**
   * Retourne une nouvelle file copie identique à f.
   *
   * @param f file à copier
   */
  public static File copier(File f) {
    File copie = new File();

    while (!f.estVide()) {
      try {
        //noinspection unchecked
        copie.enfiler(f.defiler());
      } catch (FileVide fileVide) {
        fileVide.printStackTrace();
      }
    } // while()

    return copie;
  }

  /**
   * Retourne une nouvelle file ayant les mêmes éléments mais en ordre inverse.
   *
   * @param f file à copier
   */
  public static File copierInverse(File f) {
    Pile pile = new Pile();
    File copie = new File();

    while (!f.estVide()) {
      try {
        //noinspection unchecked
        pile.empiler(f.defiler());
      } catch (FileVide fileVide) {
        fileVide.printStackTrace();
      }
    } // while()

    while (!pile.estVide()) {
      try {
        //noinspection unchecked
        copie.enfiler(pile.depiler());
      } catch (PileVide pileVide) {
        pileVide.printStackTrace();
      }
    } // while()

    return copie;
  }

  /**
   * Retourne une nouvelle pile ayant les mêmes éléments mais en ordre inverse.
   *
   * @param p pile à copier
   */
  public static Pile copierInverse(Pile p) {
    Pile copie = new Pile();

    while (!p.estVide()) {
      try {
        //noinspection unchecked
        copie.empiler(p.depiler());
      } catch (PileVide pileVide) {
        pileVide.printStackTrace();
      }
    } // while()

    return copie;
  } // copierInverse()

}
