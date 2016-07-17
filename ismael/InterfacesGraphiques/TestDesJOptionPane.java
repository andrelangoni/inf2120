package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * TestDesJOptionPane: Exemple des boîtes de dialogue pour
 * les messages :
 *  - d'information;
 *  - d'erreur
 *  - de question 
 * 
 * Université du Québec à Montréal 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Novembre 2011 
 * Modifié en Mars 2014
 * 
 */
public class TestDesJOptionPane {

	public static void main(String[] args) {
				
		// Message d'information avec le bouton OK
		JOptionPane.showMessageDialog(null,
						"Message d'information",
						"Information",
						JOptionPane.INFORMATION_MESSAGE);
		
		// Message d'erreur avec le bouton OK
		JOptionPane.showMessageDialog(null,
			    		"Message d'erreur",
			    		"Erreur",
			    		JOptionPane.ERROR_MESSAGE);
		
		// Message d'avertissement avec le bouton OK
		JOptionPane.showMessageDialog(null,
			    		"Message d'avertissement",
			    		"Avertissement",
			    		JOptionPane.WARNING_MESSAGE);
		
		// Question avec les boutons de réponse Oui et Non
		JOptionPane.showConfirmDialog(null,
				        "Êtes-vous un étudiant du cours INF2120 ?",
				        "UQAM",
				        JOptionPane.YES_NO_OPTION);
		
		// Question avec les boutons de réponse Oui, Non et Annuler
		JOptionPane.showConfirmDialog(null,"Aimez-vous le cours INF2120 ?");
		
		// Saisir le nom et le prénom dans un seul champs texte.
		JOptionPane.showInputDialog(null ,
				    "Entrez votre nom et prénom",
				    "Informations de l'étudiant(e)", 
				    JOptionPane.INFORMATION_MESSAGE);
		
		// Question avec les boutons de réponse Oui et Non
		Object[] boutons = {"Oui", "Non", "Fermer"};
		JOptionPane.showOptionDialog(null,
						"Êtes-vous un(e) étudiant(e) du cours INF2120 ?",
						"Question",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						boutons,
						boutons[0]);
		
		// Saisir le nom et le prénom dans deux (2)
		// champs texte séparés.
		JLabel etiqNom = new JLabel ("Nom :");
		JLabel etiqPrenom = new JLabel (" Prénom :");
		JTextField saisieNom = new JTextField();
		JTextField saisiePrenom = new JTextField();

		Object [] tableau = new Object []{ etiqNom, saisieNom, 
				                           etiqPrenom , saisiePrenom , null };
		
		JOptionPane.showOptionDialog( null , tableau ,
					   " Informations à saisir",
						JOptionPane. OK_CANCEL_OPTION ,
						JOptionPane. INFORMATION_MESSAGE ,
						null , null , null);

	}

	

}
