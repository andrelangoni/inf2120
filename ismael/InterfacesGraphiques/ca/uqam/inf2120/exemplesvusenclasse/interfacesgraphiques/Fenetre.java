package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fenetre : Une interface graphique contenant trois (3) boutons.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Mars 2008
 *          Modifi� en Mars 2014
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame {

  // D�claration de trois boutons
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

    // Mettre un titre sur la fen�tre
    setTitle("Fen�tre Pour tester les �v�nements");
    setSize(300, 200);

  }

  private void ajouter3boutons() {

    // Initialisation des boutons avec leur etiquette
    boutonRouge = new JButton("Rouge");
    boutonJaune = new JButton("Jaune");
    boutonVert = new JButton("Vert");

    // Mettre des �couteurs sur les trois boutons
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

    // Cr�ation de la fen�tre
    JFrame fenetre = new Fenetre();

    // Rendre visible la fen�tre
    fenetre.setVisible(true);
  }


} // Fenetre

