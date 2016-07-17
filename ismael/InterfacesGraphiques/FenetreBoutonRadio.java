package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * Fenêtre avec trois (3) boutons radio.
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2008
 * Modifié en Mars 2014
 * 
 */
public class FenetreBoutonRadio {

	public static void main(String[] args) {
		
      // Création de la fenêtre 
       JFrame fenetre = new JFrame("Fenêtre avec radio boutons");
       
       // Définir la taille de la fenêtre et 
       // son positionnement sur l'écran.
       fenetre.setBounds(400, 300, 300, 200);
       
       // Définir le gestionnaire de disposition
       FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
  
       // Ajouter le gestionnaire de disposition à la fenêtre
       fenetre.setLayout(flowLayout);
       
       // Définir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Création de trois (3) radio boutons avec les etiquettes Un, Deux, Trois
       JRadioButton  boutonRadioUn     = new JRadioButton("Un");
       JRadioButton  boutonRadioDeux   = new JRadioButton("Deux");
       JRadioButton  boutonRadioTrois  = new JRadioButton("Trois");
       
       // Sélectionner un bouton par défaut
       boutonRadioUn.setSelected(true);
       
       // Création du groupe des radio boutons
       ButtonGroup groupe = new ButtonGroup();
       
       // Ajout des radio boutons au groupe pour 
       // permettre un choix exclusif.
       groupe.add(boutonRadioUn);
       groupe.add(boutonRadioDeux);
       groupe.add(boutonRadioTrois);

       // Ajout des boutons à la fenêtre     
       fenetre.add(boutonRadioUn);  
       fenetre.add(boutonRadioDeux); 
       fenetre.add(boutonRadioTrois); 
       
       // Rendre visible la fenêtre
       fenetre.setVisible(true); 
      

	}  

	    
} // FenetreBoutonRadio


