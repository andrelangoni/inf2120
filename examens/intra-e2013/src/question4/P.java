package question4;

/**
 * Héritage - Redéfinition de la méthode dePeutEtre()
 */
public class P {
  public static void main(String[] args) {
    PeutEtre[] r = new PeutEtre[5];
    r[0] = new Rien();
    r[1] = new Seulement(1);
    r[2] = new Seulement(2);
    r[3] = new Rien();
    r[4] = new Seulement(3);
    for (int i = 0; i < 5; ++i) {
      System.out.println(r[i].dePeutEtre(0));
    } // for
  } // main()
} // P
