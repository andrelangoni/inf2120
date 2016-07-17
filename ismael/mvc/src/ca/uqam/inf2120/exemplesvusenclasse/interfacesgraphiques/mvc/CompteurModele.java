package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques.mvc;

/**
 * CompteurModele: Le modèle (Model) de l'exemple du Pattern MVC
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Juin 2009
 *          Modifié en Mars 2014
 */
public class CompteurModele {
  private int valeur;

  // Constructeur
  CompteurModele() { valeur = 0; }

  /**
   * Incrementer l'attribut "valeur"
   */
  public final void incrementer() { valeur++; }

  /**
   * Mettre -1 dans l'attribut "valeur"
   */
  public final void gagnerArgent() { valeur = -1; }

  /**
   * Mettre  la valeur 0 dans l'attribut "valeur"
   */
  public final void initialise() { valeur = 0; }

  /**
   * @return the texte
   */
  public final String getValeur() {
    if (valeur == -1) {
      return " Il faut travailler pour gagner 2000$";
    } // if
    return String.valueOf(valeur);
  } // getValeur()
} // CompteurModele