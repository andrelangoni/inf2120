package question2.constructeur;

public class Employe extends Personne {
  private String matricule;
  private float salaire;

  public Employe(){
    super();
  }
  public Employe(String prenom, String nom,
                 String matricule, float salaire ){
    //super();
    System.out.println("Employe()");
    this.matricule = matricule;
    this.salaire = salaire;
  }
}
