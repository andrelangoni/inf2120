package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fenêtre avec démonstration de positionnement des composants
 * dans un conteneur selon FlowLayout.
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */
public class FenetreFlowLayout {

	public static void main(String[] args) {
		
       // Création de la fenêtre 
       JFrame fenetre = new JFrame("FlowLayout ");
       
       // Définir la taille de la fenêtre et 
       // son positionnement sur lécran.
       fenetre.setBounds(400, 300, 300, 200);
       
       // Définir le gestionnaire de disposition
       FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
  
       // Ajouter le gestionnaire de disposition à la fenêtre
       fenetre.setLayout(flowLayout);
       
       // Définir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Création des boutons 
       JButton bouton1  = new JButton("BOUTON 1");
       JButton bouton2  = new JButton("BOUTON 2");
       JButton bouton3  = new JButton("BOUTON 3");
       JButton bouton4  = new JButton("BOUTON 4");
       JButton bouton5  = new JButton("BOUTON 5");
       JButton bouton6  = new JButton("BOUTON 6");
       JButton bouton7  = new JButton("BOUTON 7");
       JButton bouton8  = new JButton("BOUTON 8");
     
       // Ajout des boutons à la fenêtre
       fenetre.add(bouton1);  
       fenetre.add(bouton2); 
       fenetre.add(bouton3); 
       fenetre.add(bouton4); 
       fenetre.add(bouton5); 
       fenetre.add(bouton6); 
       fenetre.add(bouton7); 
       fenetre.add(bouton8); 
       
       // Rendre visible la fenêtre
       fenetre.setVisible(true); 
          



	}
} // FenetreFlowLayout

