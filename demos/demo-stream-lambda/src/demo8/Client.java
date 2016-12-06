package demo8;

public class Client {
  private String prenom;
  private String nom;
  private String noMembre;

  public Client(String prenom, String nom, String noMembre) {
    this.prenom = prenom;
    this.nom = nom;
    this.noMembre = noMembre;
  }

  @Override
  public boolean equals(Object obj) {
    boolean resultat = false;

    if (obj instanceof Client) {
      Client temp = (Client) obj;
      //noinspection StringEquality
      resultat = temp.noMembre == noMembre;
    }

    return resultat;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getNoMembre() {
    return noMembre;
  }
}
