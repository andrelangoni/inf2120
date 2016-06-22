package surcharge;

public class TestSurcharge {
  public static void main(String[] args) {
    Personne pers = new Personne();
    Employe emp = new Employe();
    Enseignant ens = new Enseignant();
    ens.valider(ens);
    ens.valider(emp);
    ens.valider(pers);
  }
}