package redefinition;

public class TestRedefinition {
  public static void main(String[] args) {
    Object o = null;
    Personne pers = new Personne();
    pers.equals(o);
    pers.toString();
    Employe emp = new Employe();
    emp.equals(o);
    emp.toString();
    Enseignant ens = new Enseignant();
    ens.equals(o);
    ens.toString();
    pers = emp;
    pers.equals(o);
    pers.toString();
    pers = ens;
    pers.equals(o);
    pers.toString();
  }
}
