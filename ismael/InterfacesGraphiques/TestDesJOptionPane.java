package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * TestDesJOptionPane: Exemple des bo�tes de dialogue pour
 * les messages :
 *  - d'information;
 *  - d'erreur
 *  - de question 
 * 
 * Universit� du Qu�bec � Montr�al 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Novembre 2011 
 * Modifi� en Mars 2014
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
		
		// Question avec les boutons de r�ponse Oui et Non
		JOptionPane.showConfirmDialog(null,
				        "�tes-vous un �tudiant du cours INF2120 ?",
				        "UQAM",
				        JOptionPane.YES_NO_OPTION);
		
		// Question avec les boutons de r�ponse Oui, Non et Annuler
		JOptionPane.showConfirmDialog(null,"Aimez-vous le cours INF2120 ?");
		
		// Saisir le nom et le pr�nom dans un seul champs texte.
		JOptionPane.showInputDialog(null ,
				    "Entrez votre nom et pr�nom",
				    "Informations de l'�tudiant(e)", 
				    JOptionPane.INFORMATION_MESSAGE);
		
		// Question avec les boutons de r�ponse Oui et Non
		Object[] boutons = {"Oui", "Non", "Fermer"};
		JOptionPane.showOptionDialog(null,
						"�tes-vous un(e) �tudiant(e) du cours INF2120 ?",
						"Question",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						boutons,
						boutons[0]);
		
		// Saisir le nom et le pr�nom dans deux (2)
		// champs texte s�par�s.
		JLabel etiqNom = new JLabel ("Nom :");
		JLabel etiqPrenom = new JLabel (" Pr�nom :");
		JTextField saisieNom = new JTextField();
		JTextField saisiePrenom = new JTextField();

		Object [] tableau = new Object []{ etiqNom, saisieNom, 
				                           etiqPrenom , saisiePrenom , null };
		
		JOptionPane.showOptionDialog( null , tableau ,
					   " Informations � saisir",
						JOptionPane. OK_CANCEL_OPTION ,
						JOptionPane. INFORMATION_MESSAGE ,
						null , null , null);

	}

	

}
