package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * FenetreEcouteurClasseInterne: Exemple de gestion des événements
 * avec la stratégie "Classe interne".
 * 
 * Université du Québec à Montréal 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifié en Mars 2014
 * 
 */
@SuppressWarnings("serial")
public class FenetreEcouteurClasseInterne extends JFrame  {     

	// Déclaration de trois boutons
	private JButton boutonRouge; 
	private JButton boutonJaune; 
	private JButton boutonVert; 
	private Ecouteur ecouteur;


	// constructeur de la classe FenetreEvenement
	public FenetreEcouteurClasseInterne() {
		
		// Ajout de 3 boutons au panneau
		ajouter3boutons();

		// Mettre un titre sur la fenêtre
		setTitle("Gestion des événements : Stratégie \"Classe Interne\"");
		setBounds(300, 200, 500, 200);

		// Définir  le type de fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	// Création et ajout des composants au conteneur
	private void ajouter3boutons() {
		
		// Initialisation des boutons avec leur etiquette
		boutonRouge = new JButton("Rouge");
		boutonJaune = new JButton("Jaune");
		boutonVert = new JButton("Vert");

		// Mettre des écouteurs sur les trois boutons
		ecouteur = new Ecouteur();
		boutonRouge.addActionListener(ecouteur);
		boutonJaune.addActionListener(ecouteur);
		boutonVert.addActionListener(ecouteur);
	  
	    // Ajouter le gestionnaire de disposition à la fenêtre
	    setLayout(new FlowLayout());
	       
		// Insertion des trois boutons dans l'objet panneau
		add(boutonRouge);
		add(boutonJaune);
		add(boutonVert);

	} 
	
	
	
	
	
	public static void main (String arg [ ]) {
	    
	   // Création de la fenêtre 
	   JFrame fenetre = new FenetreEcouteurClasseInterne(); 
	   
	   // Rendre visible la fenêtre
	   fenetre.setVisible(true); 
	
	
	}  
	
	
	// ---------------------------------------------------------
	// Classe Interne
	// ---------------------------------------------------------
	private class Ecouteur implements ActionListener {   // interface écouteur d'événements  
		
		// Implantation de la méthode de l'interface ActionListener (Ecouteur)
		public void actionPerformed(ActionEvent evt){  
			
		  // Obtenir la source d'évènement 
		  Object source = evt.getSource(); 
		  
		  // Obtenir la couleur de font du panneau
		  Color color = getContentPane().getBackground(); 
		  
		  // Permet de traiter l'événement en fonction de l'objet source 
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
		
		
	}

	
	

} // FenetreEcouteurClasseInterne
