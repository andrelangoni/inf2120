package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques.mvc;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * CompteurVue: La vue (View) de l'exemple du Pattern MVC
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Juin 2009
 *          Modifié en Mars 2014
 */
@SuppressWarnings("serial")
public class CompteurVue extends JFrame {
  // instance variables etc
  private CompteurControleur aControleur;
  private JButton incrementeButton;
  private JButton initialiseButton;
  private JButton clique;
  private JLabel etiquetteValeur;
  private JLabel valeur;


  // Constructeur
  CompteurVue() {

    init();

    // Création du controleur (Controller du MVC)
    aControleur = new CompteurControleur(this);

    // Ajouter le controleur (écouteur) aux
    // composants
    incrementeButton.addActionListener(aControleur);
    initialiseButton.addActionListener(aControleur);
    clique.addActionListener(aControleur);


  }

  // Créer les composants et les ajouter au conteneur
  private void init() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    incrementeButton = new JButton();
    incrementeButton.setText("Incrementer");

    initialiseButton = new JButton();
    initialiseButton.setText("Mettre à 0");

    etiquetteValeur = new JLabel();
    etiquetteValeur.setText("Valeur  : ");

    valeur = new JLabel();
    valeur.setText(" 0 ");

    clique = new JButton();
    clique.setText("Loterie : clique ici pour avoir 2000$");

    setSize(900, 200);
    setResizable(false);

    GridLayout gestionnaireDisposition = new GridLayout(2, 3, 5, 5);
    setLayout(gestionnaireDisposition);
    add(incrementeButton);
    add(initialiseButton);
    add(clique);
    add(etiquetteValeur);
    add(valeur);

  }

  // Rafraichir la vue
  public void refresh(String texte) {
    this.valeur.setText(texte);
  }

  /**
   * @return the clique
   */
  public JButton getClique() {
    return clique;
  }

  /**
   * @return the incrementeButton
   */
  public JButton getIncrementeButton() {
    return incrementeButton;
  }

  /**
   * @return the initialiseButton
   */
  public JButton getInitialiseButton() {
    return initialiseButton;
  }

  // Le main pour démarrer l'application
  public static void main(String[] args) {
    CompteurVue laVue = new CompteurVue();
    laVue.setVisible(true);
  } // main()
} // CompteurVue