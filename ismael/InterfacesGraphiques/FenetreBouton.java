package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Fenêtre avec trois (3) boutons.
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2008
 * Modifié en Mars 2014
 * 
 */
public class FenetreBouton {

	public static void main(String[] args) {
		
       // Création de la fenêtre 
       JFrame fenetre = new JFrame("Exemple de fenetre avec boutons commande");
       fenetre.setLocation(400, 300);
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Création du gestionnaire de disposition
       FlowLayout gestionnaireDisposition = new FlowLayout ();
       
       // Lier le gestionnaire de disposition à la fenêtre
       fenetre.setLayout(gestionnaireDisposition); 
       
       // Création de trois boutons avec les etiquettes Un, Deux, Trois
       JButton boutonUn     = new JButton("Un");
       JButton boutonDeux   = new JButton("Deux");
       JButton boutonTrois  = new JButton("Trois");
       
       // Ajout des boutons à la fenêtre
       fenetre.add(boutonUn);  
       fenetre.add(boutonDeux); 
       fenetre.add(boutonTrois); 
       
       // Adapter la fenêtre à son contenu pour l'affichage en calculant 
       // la taille de la fenêtre en fonction de celle de ses composants 
       // internes (Pas besoin de faire si la taille de la fenêtre est définie)
       fenetre.pack();   
       
       // Rendre visible la fenêtre
       fenetre.setVisible(true); 



	}

} // FenetreBouton

