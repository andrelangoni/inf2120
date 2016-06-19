package question4;

public class Etudiant extends Personne {
  private String code;

  public Etudiant(String nom, String code) {
    super(nom);
    this.code = code;
  }

  public String ident() {
    return "un étudiant";
  }
}
