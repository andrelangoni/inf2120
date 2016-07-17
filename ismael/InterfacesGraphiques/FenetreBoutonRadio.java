package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * Fen�tre avec trois (3) boutons radio.
 *  
 * Universit� du  Qu�bec � Montr�al
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2008
 * Modifi� en Mars 2014
 * 
 */
public class FenetreBoutonRadio {

	public static void main(String[] args) {
		
      // Cr�ation de la fen�tre 
       JFrame fenetre = new JFrame("Fen�tre avec radio boutons");
       
       // D�finir la taille de la fen�tre et 
       // son positionnement sur l'�cran.
       fenetre.setBounds(400, 300, 300, 200);
       
       // D�finir le gestionnaire de disposition
       FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
  
       // Ajouter le gestionnaire de disposition � la fen�tre
       fenetre.setLayout(flowLayout);
       
       // D�finir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Cr�ation de trois (3) radio boutons avec les etiquettes Un, Deux, Trois
       JRadioButton  boutonRadioUn     = new JRadioButton("Un");
       JRadioButton  boutonRadioDeux   = new JRadioButton("Deux");
       JRadioButton  boutonRadioTrois  = new JRadioButton("Trois");
       
       // S�lectionner un bouton par d�faut
       boutonRadioUn.setSelected(true);
       
       // Cr�ation du groupe des radio boutons
       ButtonGroup groupe = new ButtonGroup();
       
       // Ajout des radio boutons au groupe pour 
       // permettre un choix exclusif.
       groupe.add(boutonRadioUn);
       groupe.add(boutonRadioDeux);
       groupe.add(boutonRadioTrois);

       // Ajout des boutons � la fen�tre     
       fenetre.add(boutonRadioUn);  
       fenetre.add(boutonRadioDeux); 
       fenetre.add(boutonRadioTrois); 
       
       // Rendre visible la fen�tre
       fenetre.setVisible(true); 
      

	}  

	    
} // FenetreBoutonRadio


