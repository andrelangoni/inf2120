package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Fen�tre avec trois (3) boutons.
 *  
 * Universit� du  Qu�bec � Montr�al
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2008
 * Modifi� en Mars 2014
 * 
 */
public class FenetreBouton {

	public static void main(String[] args) {
		
       // Cr�ation de la fen�tre 
       JFrame fenetre = new JFrame("Exemple de fenetre avec boutons commande");
       fenetre.setLocation(400, 300);
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Cr�ation du gestionnaire de disposition
       FlowLayout gestionnaireDisposition = new FlowLayout ();
       
       // Lier le gestionnaire de disposition � la fen�tre
       fenetre.setLayout(gestionnaireDisposition); 
       
       // Cr�ation de trois boutons avec les etiquettes Un, Deux, Trois
       JButton boutonUn     = new JButton("Un");
       JButton boutonDeux   = new JButton("Deux");
       JButton boutonTrois  = new JButton("Trois");
       
       // Ajout des boutons � la fen�tre
       fenetre.add(boutonUn);  
       fenetre.add(boutonDeux); 
       fenetre.add(boutonTrois); 
       
       // Adapter la fen�tre � son contenu pour l'affichage en calculant 
       // la taille de la fen�tre en fonction de celle de ses composants 
       // internes (Pas besoin de faire si la taille de la fen�tre est d�finie)
       fenetre.pack();   
       
       // Rendre visible la fen�tre
       fenetre.setVisible(true); 



	}

} // FenetreBouton

