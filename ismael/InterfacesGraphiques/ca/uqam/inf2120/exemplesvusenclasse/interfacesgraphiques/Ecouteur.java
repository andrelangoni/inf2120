package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur : Une classe qui implémente l'interfac "ActionListener".
 * 
 * Université du Québec à Montréal 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifié en Mars 2014
 */
public class Ecouteur implements ActionListener {

	private Fenetre fenetre;

	
	public Ecouteur(Fenetre f) {
		this.fenetre = f;

	}

	// Implantation de la méthode de l'interface 
	// ActionListener (Ecouteur)
	public void actionPerformed(ActionEvent evt) {
		
		// Obtenir la source d'évènement
		Object source = evt.getSource();
		// Obtenir la couleur de font du panneau
		Color color = fenetre.getContentPane().getBackground();

		// Permet de traiter l'événement en fonction de l'objet source
		if (source == fenetre.getBoutonRouge()) {
			color = Color.red;
		} else if (source == fenetre.getBoutonJaune()) {
			color = Color.yellow;
		} else if (source == fenetre.getBoutonVert()) {
			color = Color.green;
		}
		
		// Mettre la nouvelle couleur de fond du panneau
		fenetre.getContentPane().setBackground(color);
		fenetre.getContentPane().repaint();
	}

} // Ecouteur

