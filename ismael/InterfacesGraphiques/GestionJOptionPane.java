package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import javax.swing.JOptionPane;

/**
 * TestDesJOptionPane: Gestion des événements.
 * 
 * Université du Québec à Montréal 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Novembre 2011 
 * Modifié en Mars 2014
 * 
 */
public class GestionJOptionPane {

	public static void main(String[] args) {
		

		// Question avec les boutons de réponse Oui et Non
		int reponse = JOptionPane.showConfirmDialog(null,
				        "Êtes-vous un(e) étudiant(e) du cours INF2120 ?",
				        "UQAM",
				        JOptionPane.YES_NO_OPTION);
		
		// Si la réponse est Oui
		if (reponse == JOptionPane.OK_OPTION) {
			// Afficher un message d'information
			JOptionPane.showMessageDialog(null, "Bienvenue dans la salle !",
					"Message d'information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			// Afficher un message d'information
			JOptionPane.showMessageDialog(null, "Quittez la salle sans faire de bruit !",
					"Message d'information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// Saisir une information
		String saisie = JOptionPane.showInputDialog(null ,
						    "Entrez votre nom et prénom",
						    "Informations de l'étudiant(e)", 
						    JOptionPane.INFORMATION_MESSAGE);
		
		if (!saisie.isEmpty()) {
			// Afficher un message d'information
			JOptionPane.showMessageDialog(null, saisie + ", Bienvenue dans la salle !",
					"Message d'information", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	

}
