package ca.uqam.inf2120.exemplesvusenclasse.interfacesgraphiques;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Fen�tre Client.
 * 
 * Universit� du Qu�bec � Montr�al 
 * 
 * INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifi� en Mars 2014
 * 
 */
@SuppressWarnings("serial")
public class FenetreUnClient extends JFrame {

	// D�clarations des attributs
	
	// Panneau de haut et ses composants
	JPanel panneauHaut;
	GridLayout gestionnairePanneauHaut = new GridLayout(2, 1);
	JRadioButton radioBoutonResidentiel;
	JRadioButton radioBoutonEntreprise;
	ButtonGroup groupeClient;

	// Panneau du milieu et ses composants
	JPanel panneauMilieu;
	GridLayout gestionnairePanneauMilieu;
	JLabel nom;
	JTextField saisieNom;
	JLabel prenom;
	JTextField saisiePrenom;
	JLabel telephone;
	JTextField saisieTelephone;
	JLabel adresse;
	JTextArea saisieAdresse;
	JLabel grpeFacturation;
	JComboBox<String> choixFacturation;

	// Panneau du bas et ses composants
	JPanel panneauBas;
	JButton boutonSauvegarder;
	JButton boutonFermer;
	FlowLayout gestionnairePanneauBas;


	// Constructeur sans arguments
	public FenetreUnClient() {
		// Cr�e tous les conteneurs
		// et composants de la fen�tre
		init();
	}

	// Programme principal
	public static void main(String[] args) {
		FenetreUnClient fenetreClient = new FenetreUnClient();
		fenetreClient.setVisible(true);
	
	}

	// Cr�e tous les conteneurs et composants de la fen�tre
	private void init() {

		// Cr�ation du panneau de haut avec ses composants.
		panneauHaut = new JPanel();
		panneauHaut.setBorder(new TitledBorder(null, "Type de client",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauHaut.setLayout(gestionnairePanneauHaut);

		radioBoutonResidentiel = new JRadioButton();
		radioBoutonResidentiel.setSelected(true);
		radioBoutonResidentiel.setText("R�sidentiel");

		radioBoutonEntreprise = new JRadioButton();
		radioBoutonEntreprise.setText("Entreprise");

		groupeClient = new ButtonGroup();
		groupeClient.add(radioBoutonResidentiel);
		groupeClient.add(radioBoutonEntreprise);

		panneauHaut.add(radioBoutonResidentiel, null);
		panneauHaut.add(radioBoutonEntreprise, null);

		// Cr�ation du panneau du milieu avec ses composants.
		panneauMilieu = new JPanel();
		panneauMilieu.setBorder(new TitledBorder(null,
				"Informations du client", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		gestionnairePanneauMilieu = new GridLayout(5, 2);
		gestionnairePanneauMilieu.setVgap(3);
		gestionnairePanneauMilieu.setHgap(3);
		panneauMilieu.setLayout(gestionnairePanneauMilieu);

		nom = new JLabel("Nom");
		saisieNom = new JTextField();
		panneauMilieu.add(nom);
		panneauMilieu.add(saisieNom);

		prenom = new JLabel("Pr�nom");
		saisiePrenom = new JTextField();
		panneauMilieu.add(prenom);
		panneauMilieu.add(saisiePrenom);

		telephone = new JLabel("T�l�phone");
		saisieTelephone = new JTextField();
		panneauMilieu.add(telephone);
		panneauMilieu.add(saisieTelephone);

		adresse = new JLabel("Adresse");
		saisieAdresse = new JTextArea(2, 12);
		panneauMilieu.add(adresse);
		panneauMilieu.add(saisieAdresse);

		grpeFacturation = new JLabel("Groupe de Facturation");
		choixFacturation = new JComboBox<String>();
		choixFacturation.addItem("Hebdomadaire");
		choixFacturation.addItem("Mensuel");
		choixFacturation.addItem("Annuel");
		panneauMilieu.add(grpeFacturation);
		panneauMilieu.add(choixFacturation);

		// Cr�ation du panneau du bas avec ses composants.
		panneauBas = new JPanel();
		gestionnairePanneauBas = new FlowLayout(FlowLayout.RIGHT);
		panneauBas.setLayout(gestionnairePanneauBas);

		boutonSauvegarder = new JButton("Sauvegarder");
		boutonFermer = new JButton("Fermer");

		panneauBas.add(boutonSauvegarder);
		panneauBas.add(boutonFermer);

		// Personnalisation du cadre central
		setTitle("Cr�ation d\'un client");
		// D�finir la taille de la fen�tre et
		// son positionnement sur l�cran.
		setBounds(400, 300, 300, 330);

		add(panneauHaut, BorderLayout.NORTH);
		add(panneauMilieu, BorderLayout.CENTER);
		add(panneauBas, BorderLayout.SOUTH);

		// D�finir le type de fermetire
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
