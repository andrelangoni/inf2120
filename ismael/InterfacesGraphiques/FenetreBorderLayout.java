package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fen�tre avec d�monstration de positionnement des composants
 * dans un conteneur selon BorderLayout.
 *  
 * Universit� du  Qu�bec � Montr�al
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */
public class FenetreBorderLayout {

	public static void main(String[] args) {
		
       // Cr�ation de la fen�tre. 
       JFrame fenetre = new JFrame("BorderLayout ");
       
       // D�finir la taille de la fen�tre et 
       // son positionnement sur l�cran.
       fenetre.setBounds(400, 300, 300, 200); 
       
       // D�finir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Cr�ation des boutons 
       JButton bCentre = new JButton("CENTRE");
       JButton bNord   = new JButton("NORD");
       JButton bSud    = new JButton("SUD");
       JButton bOuest  = new JButton("OUEST");
       JButton bEst    = new JButton("EST");
     
       // Ajout des boutons � la fen�tre
       // Par d�faut, le gestionnaire de disposition
       // de JFrame est BorderLayout.
       fenetre.add(bCentre, BorderLayout.CENTER);  
       fenetre.add(bNord, BorderLayout.NORTH); 
       fenetre.add(bSud, BorderLayout.SOUTH); 
       fenetre.add(bOuest, BorderLayout.WEST); 
       fenetre.add(bEst, BorderLayout.EAST); 
       
       // Rendre visible la fen�tre
       fenetre.setVisible(true); 

	}
} // FenetreBorderLayout

