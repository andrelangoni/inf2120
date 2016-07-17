package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fenetre : Une interface graphique contenant trois (3) boutons.
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Mars 2008
 *          Modifié en Mars 2014
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame {

  // Déclaration de trois boutons
  private JButton boutonRouge;
  private JButton boutonJaune;
  private JButton boutonVert;
  private Ecouteur ecouteur;

  // constructeur de la classe FenetreEvenement
  public Fenetre() {

    // Terminer l'application
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Ajout de 3 boutons au panneau
    ecouteur = new Ecouteur(this);
    ajouter3boutons();

    // Mettre un titre sur la fenêtre
    setTitle("Fenêtre Pour tester les évènements");
    setSize(300, 200);

  }

  private void ajouter3boutons() {

    // Initialisation des boutons avec leur etiquette
    boutonRouge = new JButton("Rouge");
    boutonJaune = new JButton("Jaune");
    boutonVert = new JButton("Vert");

    // Mettre des écouteurs sur les trois boutons
    boutonRouge.addActionListener(ecouteur);
    boutonJaune.addActionListener(ecouteur);
    boutonVert.addActionListener(ecouteur);


    // Ajouter les trois (3) boutons dans la fenetre
    setLayout(new FlowLayout());
    add(boutonRouge);
    add(boutonJaune);
    add(boutonVert);

  }

  /**
   * @return the boutonRouge
   */
  public JButton getBoutonRouge() {
    return boutonRouge;
  }

  /**
   * @return the boutonJaune
   */
  public JButton getBoutonJaune() {
    return boutonJaune;
  }

  /**
   * @return the boutonVert
   */
  public JButton getBoutonVert() {
    return boutonVert;
  }


  // Main pour lancer l'application
  public static void main(String arg[]) {

    // Création de la fenêtre
    JFrame fenetre = new Fenetre();

    // Rendre visible la fenêtre
    fenetre.setVisible(true);
  }


} // Fenetre

