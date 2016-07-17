package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fenêtre avec démonstration de positionnement des composants
 * dans un conteneur selon BorderLayout.
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */
public class FenetreBorderLayout {

	public static void main(String[] args) {
		
       // Création de la fenêtre. 
       JFrame fenetre = new JFrame("BorderLayout ");
       
       // Définir la taille de la fenêtre et 
       // son positionnement sur lécran.
       fenetre.setBounds(400, 300, 300, 200); 
       
       // Définir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Création des boutons 
       JButton bCentre = new JButton("CENTRE");
       JButton bNord   = new JButton("NORD");
       JButton bSud    = new JButton("SUD");
       JButton bOuest  = new JButton("OUEST");
       JButton bEst    = new JButton("EST");
     
       // Ajout des boutons à la fenêtre
       // Par défaut, le gestionnaire de disposition
       // de JFrame est BorderLayout.
       fenetre.add(bCentre, BorderLayout.CENTER);  
       fenetre.add(bNord, BorderLayout.NORTH); 
       fenetre.add(bSud, BorderLayout.SOUTH); 
       fenetre.add(bOuest, BorderLayout.WEST); 
       fenetre.add(bEst, BorderLayout.EAST); 
       
       // Rendre visible la fenêtre
       fenetre.setVisible(true); 

	}
} // FenetreBorderLayout

