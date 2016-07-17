package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CompteurControleur: Le controleur (Controller) de l'exemple du Pattern MVC
 * <p>
 * Universit� du Qu�bec � Montr�al
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Juin 2009
 *          Modifi� en Mars 2014
 */
public class CompteurControleur implements ActionListener {
  private CompteurModele modele;
  private CompteurVue vue;

  // Constructeur avec la vue � controler comme param�tre
  CompteurControleur(CompteurVue uneVue) {
    this.modele = new CompteurModele();
    vue = uneVue;
    vue.refresh(modele.getValeur());
  }

  /**
   * @return the modele
   */
  public CompteurModele getModele() {
    return modele;
  }


  // La red�finition  de l'unique m�thode de l'interface
  // ActionListener
  public void actionPerformed(ActionEvent event) {
    // Obtenir la source de l'�v�nement.
    Object source = event.getSource();

    // Si l'�v�nement a �t� g�n�r� par le bouton
    // "Incrementer"
    if (source == vue.getIncrementeButton()) {
      // Appeler la fonction "incrementer"
      // du mod�le
      modele.incrementer();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());

      // Sinon si l'�v�nement a �t� g�n�r� par le bouton
      // "Initialiser"
    } else if (source == vue.getInitialiseButton()) {
      // Appeler la fonction "initialiser"
      // du mod�le
      modele.initialise();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());

      // Sinon si l'�v�nement a �t� g�n�r� par le bouton
      // "Clique"
    } else if (source == vue.getClique()) {
      // Appeler la fonction "gagnerArgent"
      // du mod�le
      modele.gagnerArgent();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());
    }
  }
}
