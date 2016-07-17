package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * FenetreEcouteurStrategieThis: Exemple de gestion des �v�nements
 * avec la strat�gie "this".
 * 
 * Universit� du Qu�bec � Montr�al 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifi� en Mars 2014
 * 
 */
@SuppressWarnings("serial")
public class FenetreEcouteurStrategieThis extends JFrame implements ActionListener { 

	// D�claration de trois boutons
	private JButton boutonRouge;
	private JButton boutonJaune;
	private JButton boutonVert;

	// constructeur 
	public FenetreEcouteurStrategieThis() {

		// Ajout de 3 boutons au panneau
		ajouter3boutons();

		// Mettre un titre sur la fen�tre
		setTitle("Gestion des �v�nements : Strat�gie \"this\"");
		setBounds(300, 200, 450, 200);

		// D�finir  le type de fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void ajouter3boutons() {

		// Initialisation des boutons avec leur etiquette
		boutonRouge = new JButton("Rouge");
		boutonJaune = new JButton("Jaune");
		boutonVert = new JButton("Vert");

		// Mettre des �couteurs sur les trois boutons
		boutonRouge.addActionListener(this);
		boutonJaune.addActionListener(this);
		boutonVert.addActionListener(this);
	  
	    // Ajouter le gestionnaire de disposition � la fen�tre
	    setLayout(new FlowLayout());
	       
		// Insertion des trois boutons dans l'objet panneau
		add(boutonRouge);
		add(boutonJaune);
		add(boutonVert);

	}

	// Implantation de la m�thode de l'interface ActionListener (Ecouteur)
	public void actionPerformed(ActionEvent evt) {
		// Obtenir la source d'�v�nement
		Object source = evt.getSource();
		
		// Obtenir la couleur de font du panneau
		Color color = getContentPane().getBackground();

		// Permet de traiter l'�v�nement en fonction de l'objet source
		if (source == boutonRouge) {
			color = Color.red;
		} else if (source == boutonJaune) {
			color = Color.yellow;
		} else if (source == boutonVert) {
			color = Color.green;
		}
		// Mettre la nouvelle couleur de fond du panneau
		getContentPane().setBackground(color);
		getContentPane().repaint();
	}

	// Main
	public static void main(String arg[]) {

		// Cr�ation de la fen�tre
		JFrame fenetre = new FenetreEcouteurStrategieThis();

		// Rendre visible la fen�tre
		fenetre.setVisible(true);

	}

} // FenetreEcouteurStrategieThis
