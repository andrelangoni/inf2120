import techniquesRecherche.RechercheBinaire;
import techniquesRecherche.RechercheSequentielle;

public class Main {
  public static void main(String[] args) {
    //question1();
    //question2();
    question7();
  } // main()

  private static void question7() {
    Integer[] tab = {1, 2, 5, 7, 12, 17, 18, 19, 20, 25, 26, 28, 35, 40, 42, 43, 53, 56, 57, 61, 64, 73, 77, 87};
    RechercheSequentielle<Integer> rechercheSequentielle = new RechercheSequentielle<>();
    RechercheBinaire<Integer> rechercheBinaire = new RechercheBinaire<>();

    Integer vingtCinq = 25;
    println("Recherche non-ordonnee de " + String.valueOf(vingtCinq));
    rechercheSequentielle.rechercheSeqNonOrdonnee(tab, vingtCinq);

    Integer trente = 30;
    println("\nRecherche non-ordonnee de " + String.valueOf(trente));
    rechercheSequentielle.rechercheSeqNonOrdonnee(tab, trente);

    println("\nRecherche ordonnee de " + String.valueOf(vingtCinq));
    rechercheSequentielle.rechercheSeqOrdonnee(tab, vingtCinq);

    println("\nRecherche ordonnee de " + String.valueOf(trente));
    rechercheSequentielle.rechercheSeqOrdonnee(tab, trente);

    Integer dixNeuf = 19;
    println("\nRecherche binaire de " + String.valueOf(dixNeuf));
    rechercheBinaire.rechercheBinaireIterative(tab, 0, tab.length - 1, dixNeuf);

    Integer cinquente = 50;
    println("\nRecherche binaire de " + String.valueOf(cinquente));
    rechercheBinaire.rechercheBinaireIterative(tab, 0, tab.length - 1, cinquente);
  } // question7()

  public static void question1() {
    Maillon<Integer> p = new Maillon<Integer>(3);
    Maillon<Integer> w = new Maillon<Integer>(4, p);
    p = new Maillon<Integer>(5, w);
    w = new Maillon<Integer>(6, p.suivant());
    p.modifierSuivant(w);

    // question 3
    println("Question 3 - nbMaillons = ... " + String.valueOf(nbMaillons(p)));

    // question 1
    println("Question 1");
    while (p != null) {
      System.out.println(p.info());
      p = p.suivant();
    } // while
  } // question1()

  public static void question2() {
    println("Question 2");
    Maillon<Integer> p = new Maillon<Integer>(1);
    Maillon<Integer> w = new Maillon<Integer>(2);
    Maillon<Integer> x = new Maillon<Integer>(3, w);
    p.modifierSuivant(x.suivant());
    x.suivant().modifierSuivant(w);
    p.modifierSuivant(new Maillon<Integer>(4, w));
    Maillon<Integer> a = new Maillon<Integer>(5, x.suivant().suivant());
    w.modifierSuivant(p.suivant());

    // Affichage
    println("p = " + p.toString());
    println("p.suiv = " + p.suivant().toString());
    println("w = " + w.toString());
    println("x = " + x.toString());
    println("a = " + a.toString());
  } // question2()

  private static void println(String s) {
    System.out.println(s);
  } // print()

  /* Question 3**/
  public static int nbMaillons(Maillon debut) {
    Maillon temp = debut;
    int compteur = 0;
    while (temp != null) {
      //System.out.print(temp.info() + " ");
      temp = temp.suivant();
      compteur++;
    } // while
    return compteur;
  } // nbMaillons()

} // Main