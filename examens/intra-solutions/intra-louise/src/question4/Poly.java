package question4;

public class Poly {
  public static void main(String[] args) {
// Partie (a)
    Personne toto = new Personne("x");
    Personne totoEt = new Etudiant("y", "ZZ");
    Enseignant totoEns = new Enseignant("z", "A");
    Personne totoP = new Prof("w", "AA", "mth");
// Partie (b)
    Personne machin = new Prof("m", "X13", "math");
    //System.out.println(machin.getMatricule());
    Personne tintin = new Etudiant("tintin", "R24");
    System.out.println(((Enseignant) tintin).getMatricule());
    Prof tournesol = new Prof("tryphon", "H2O", "?");
    System.out.println(tournesol.getMatricule() + tournesol);

    //Personne milou = new Prof("milou", "m", "chiens");
    //System.out.println(((Enseignant) milou).getMatricule());
  }
}
