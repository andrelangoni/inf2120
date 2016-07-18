import abr.ABR;

public class Main {
  private static ABR<Integer> arbre = new ABR<>();

  public static void main(String[] args) {
    abr();
  } // main()

  private static void abr() {
    // Attention erreur dans l'enonce
    // Echanger 3 et 2
    Integer deux = 2;
    Integer huit = 8;
    Integer dix = 10;
    Integer[] tab = {dix, 7, deux, 1, 3, huit, 9, 15, 14, 13};

    for (Integer i : tab) {
      arbre.inserer(i);
    } // for

    System.out.println("Parcours infixe");
    ABR.parcoursInfixe(arbre);
    System.out.println();

    System.out.println("Parcours prefixe");
    ABR.parcoursPrefixe(arbre);
    System.out.println();

    System.out.println("Parcours suffixe");
    ABR.parcoursSuffixe(arbre);
    System.out.println();

    supprimer(deux);
    supprimer(huit);
    supprimer(dix);
    System.out.println();
  }

  private static void supprimer(Integer deux) {
    System.out.println("Supression de " + String.valueOf(deux));
    arbre.supprimer(arbre, deux);
    ABR.parcoursInfixe(arbre);
    System.out.println();
  }
} // Main