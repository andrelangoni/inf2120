package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CompteurControleur: Le controleur (Controller) de l'exemple du Pattern MVC
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Juin 2009
 *          Modifié en Mars 2014
 */
public class CompteurControleur implements ActionListener {
  private CompteurModele modele;
  private CompteurVue vue;

  // Constructeur avec la vue à controler comme paramètre
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


  // La redéfinition  de l'unique méthode de l'interface
  // ActionListener
  public void actionPerformed(ActionEvent event) {
    // Obtenir la source de l'événement.
    Object source = event.getSource();

    // Si l'événement a été généré par le bouton
    // "Incrementer"
    if (source == vue.getIncrementeButton()) {
      // Appeler la fonction "incrementer"
      // du modèle
      modele.incrementer();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());

      // Sinon si l'événement a été généré par le bouton
      // "Initialiser"
    } else if (source == vue.getInitialiseButton()) {
      // Appeler la fonction "initialiser"
      // du modèle
      modele.initialise();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());

      // Sinon si l'événement a été généré par le bouton
      // "Clique"
    } else if (source == vue.getClique()) {
      // Appeler la fonction "gagnerArgent"
      // du modèle
      modele.gagnerArgent();
      // Rafraichir la vue
      vue.refresh(modele.getValeur());
    }
  }
}
