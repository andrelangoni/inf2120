package charles;

public class ABRTest {
  private ABR<Integer, String> arbre = new ABR<>();

  @org.junit.Before
  public void setUp() throws Exception {
    arbre.inserer(5, "manchot", arbre.racine);
    arbre.inserer(2, "couche", arbre.racine);
    arbre.inserer(0, "balle", arbre.racine);
    arbre.inserer(1, "bleu", arbre.racine);
    arbre.inserer(3, "goupille", arbre.racine);
    arbre.inserer(4, "lune", arbre.racine);
    arbre.inserer(7, "oignon", arbre.racine);
    arbre.inserer(6, "nappe", arbre.racine);
    arbre.inserer(8, "serpent", arbre.racine);
    arbre.inserer(9, "tarte", arbre.racine);
    System.out.println("setUp()");
  } // setUp()

  @org.junit.Test
  public void niveau() throws Exception {

  } // niveau()

} // ABRTest