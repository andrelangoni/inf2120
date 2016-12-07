package Demo9;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PdemoS extends JFrame {
	public static final int FREQUENCE_ECHANTILLONAGE = 44100;
	public static final int NB_CANALS = 1;
	public static final int OCTETS_PAR_ECHANTILLON = 2;
	public static final int TAILLE_CADRE = NB_CANALS * OCTETS_PAR_ECHANTILLON;
	public static final int NB_OCTETS = FREQUENCE_ECHANTILLONAGE * TAILLE_CADRE;
	public static final int AMPLITUDE_MAXIMUM = (int) (Math.pow(2, OCTETS_PAR_ECHANTILLON * 8 - 1) - 1);

	public static final int BORDURE_X = 450;
	public static final int BORDURE_Y = 350;

	protected Graphique dessin;

	private static final long serialVersionUID = 1L;

	/**
	 * Detail decrivant l'onde.
	 */
	public enum TypeOnde {
		SINUSOIDALE( "sinusoidale" ), 
		TRIANGLE( "triangle" ), 
		TRIANGLE_GENERIQUE( "triangle generique" ), 
		SCIED( "dent scie descendante" ), 
		SCIEM( "dent scie montante" ), 
		CARRE( "carre" ), 
		PULSE_GENERIQUE( "pulse generique" ), 
		BRUIT( "bruit" );
		
		public static TypeOnde [] enumeration = { SINUSOIDALE, TRIANGLE, 
				TRIANGLE_GENERIQUE, SCIED, SCIEM, CARRE, 
				PULSE_GENERIQUE, BRUIT };
		
		private String nom;
		
		private TypeOnde( String nom ) {
			this.nom = nom;
		}
		
		public String toString() {
			return nom;
		}
	}
	
	// Generique au son :
	// valeur entre 20 et 20000
	double frequence = 440.0;
	// valeur entre 0 et 2
	double duree = 1.0;
	
	// Ondes
	TypeOnde typeOnde [] = { TypeOnde.SINUSOIDALE, TypeOnde.SINUSOIDALE }; 
	// valeur entre 0 et 1, utilise si nous avons onde PULSE_GENERIQUE ou TRIANGLE_GENERIQUE.
	double ondeRatio [] = { 0.5, 0.5 };
	
	// Peut etre Onde 2 :
	boolean utilise2Ondes = true;
	// valeur entre 0 et 1
	double ratioVolume = 0.5;
	
	// Filtre :
	// filtreS est entre 0 et 1.
	// filtreA + filtreD <= duree
	boolean utiliseFiltre = true;
	double filtreA = 0.1;
	double filtreD = 0.3;
	double filtreS = 0.5;
	double filtreR = 0.1;
	
	public Onde construireOndeBase( int i ) {
		Onde resultat = null;
		switch( typeOnde[i] ) {
		case SINUSOIDALE :
			resultat = new Sinusoidale( FREQUENCE_ECHANTILLONAGE, frequence );
			break;
		case TRIANGLE :
			resultat = new Triangle( FREQUENCE_ECHANTILLONAGE, frequence );
			break;
		case SCIED :
			resultat = new ScieD( FREQUENCE_ECHANTILLONAGE, frequence );
			break;
		case SCIEM :
			resultat = new ScieM( FREQUENCE_ECHANTILLONAGE, frequence );
			break;
		case CARRE :
			resultat = new Carre( FREQUENCE_ECHANTILLONAGE, frequence );
			break;
		case BRUIT :
			resultat = new Bruit();
			break;
		case PULSE_GENERIQUE:
			resultat = new PulseGenerique( FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i] );
			break;
		case TRIANGLE_GENERIQUE:
			resultat = new TriangleGenerique( FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i] );
			break;
		}
		resultat.setDure( duree );
		return resultat;
	}
	
	public Onde construireOnde() {
		Onde resultat = construireOndeBase( 0 );
		
		if( utilise2Ondes ){
			resultat = new Mixe( resultat, 1.0 - ratioVolume, construireOndeBase( 1 ), ratioVolume ); 
			resultat.setDure( duree );
		}

		if( utiliseFiltre ){
			ADSR f = new ADSR( FREQUENCE_ECHANTILLONAGE, filtreA, filtreD, filtreS, filtreR );
			f.setDure( duree );
			resultat = new Filtre( resultat, f );
			resultat.setDure( duree );
		}
		
		return resultat;
	}
	
	
	public void jouerNote(Onde onde) {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                FREQUENCE_ECHANTILLONAGE, OCTETS_PAR_ECHANTILLON * 8, NB_CANALS,
                OCTETS_PAR_ECHANTILLON * NB_CANALS, FREQUENCE_ECHANTILLONAGE, false);

        SourceDataLine line;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                format);
        if (!AudioSystem.isLineSupported(info)) {
            System.err.print("Ligne non supporte par l'ordinateur.");
            System.exit(-1);
        }
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);

            byte[] buffer = new byte[NB_OCTETS];

            line.start();

            int j = 0;

            for (Double a : onde) {
                short amp = (short) Math.floor(AMPLITUDE_MAXIMUM * a);
                buffer[j + 0] = (byte) (amp & 0xFF);
                buffer[j + 1] = (byte) ((amp >>> 8) & 0xFF);
                j += TAILLE_CADRE;
                if (j >= NB_OCTETS) {
                    line.write(buffer, 0, NB_OCTETS);
                    j = 0;
                }
            }

            if (j != 0) {
                line.write(buffer, 0, j);
            }

            line.drain();
            line.stop();
            line.close();
        } catch (LineUnavailableException ex) {
            System.err.print("Ligne non disponible.");
            System.exit(-1);
        }
        line = null;
    }

	public void actionsJouerNote() {
		Onde onde = construireOnde();
		dessin.setFonction( onde );
		dessin.repaint();
		jouerNote( onde );
	}
	
	public PdemoS() {
		super( "Synthetiseur" );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout( new BorderLayout() );

		setSize( Graphique.TAILLE_X + BORDURE_X, 2 * Graphique.TAILLE_Y + BORDURE_Y );
	
		/**
		 * Construire l'interface.
		 */

		// NORTH
		JPanel panneauNorth = new JPanel();
		
		panneauNorth.add( new JLabel( "Duree (ms) " ) );
		
		JSlider sDuree = new JSlider( 0, 2000, 1000 );
		sDuree.addChangeListener( (e) -> duree = sDuree.getValue() / 1000.0 );
		panneauNorth.add( sDuree );
		
		panneauNorth.add( new JLabel( "Frequence " ) );
		
		JTextField tfFrequence = new JTextField( "               440.0" );
		tfFrequence.addActionListener( e -> {
			try {
				double x = Double.valueOf( tfFrequence.getText() );
				x = Math.min( x, 20000 );
				x = Math.max( x, 20 );
				frequence = x;
			} catch( NumberFormatException n ) {
			}
			tfFrequence.setText( "" + frequence );
		});
		panneauNorth.add( tfFrequence );
		
		JButton b_jouerNote = new JButton( "Jouer" );
		b_jouerNote.addActionListener( e -> actionsJouerNote() );
		panneauNorth.add( b_jouerNote );
		
		add( panneauNorth, BorderLayout.NORTH );
		
		
		
		// CENTER
		dessin = new Graphique( construireOnde() );
		add( dessin, BorderLayout.CENTER );
		
		
		
		// WEST
		JPanel panneauOuest = new JPanel( new GridLayout( 3, 1 ) );
		
		panneauOuest.add( new JLabel( "Description Onde 1 :" ) );
		
		JList<TypeOnde> list1 = new JList<>( TypeOnde.enumeration );
		list1.addListSelectionListener( e -> typeOnde[0] = list1.getSelectedValue() );
		list1.setSelectedIndex( 0 );
		panneauOuest.add( list1, BorderLayout.WEST );
		
		JSlider slider1 = new JSlider( 0, 100, 50 );
		slider1.addChangeListener( (e) -> ondeRatio[0] = slider1.getValue() / 100.0 );
		panneauOuest.add( slider1 );
		
		add( panneauOuest, BorderLayout.WEST );

		
		
		// EAST
		JPanel panneauEst = new JPanel( new GridLayout( 3, 1 ) );
		
		panneauEst.add( new JLabel( "Description Onde 2 :" ) );
		
		JList<TypeOnde> list2 = new JList<>( TypeOnde.enumeration );
		list2.addListSelectionListener( e -> typeOnde[1] = list2.getSelectedValue() );
		list2.setSelectedIndex( 0 );
		panneauEst.add( list2 );

		JSlider slider2 = new JSlider( 0, 100, 50 );
		slider2.addChangeListener( (e) -> ondeRatio[1] = slider2.getValue() / 100.0 );
		panneauEst.add( slider2 );
		
		add( panneauEst, BorderLayout.EAST );
		
		
		
		// SOUTH
		JPanel panneauSouth = new JPanel( new GridBagLayout() );
		
		JCheckBox cb = new JCheckBox( "Deuxieme onde", true );
		GridBagConstraints cCheckBoxDeuxiemeOnde = new GridBagConstraints();
		cCheckBoxDeuxiemeOnde.gridx = 0;
		cCheckBoxDeuxiemeOnde.gridwidth = 2;
		cCheckBoxDeuxiemeOnde.gridy = 0;
		cb.addActionListener( (e) -> utilise2Ondes = cb.isSelected() );
		panneauSouth.add( cb, cCheckBoxDeuxiemeOnde );
		
		GridBagConstraints cLabelRatioVolume = new GridBagConstraints();
		cLabelRatioVolume.gridx = 0;
		cLabelRatioVolume.gridy = 1;
		panneauSouth.add( new JLabel( "Ratio volume " ), cLabelRatioVolume );
		
		JSlider sVolume = new JSlider( 0, 100, 50 );
		GridBagConstraints cSliderRatioVolume = new GridBagConstraints();
		cSliderRatioVolume.gridx = 1;
		cSliderRatioVolume.gridy = 1;
		sVolume.addChangeListener( (e) -> ratioVolume = sVolume.getValue() / 100.0 );
		panneauSouth.add( sVolume, cSliderRatioVolume );
		
		
		
		JCheckBox cbFiltre = new JCheckBox( "Filtre ASDR", true );
		GridBagConstraints cCheckBoxFiltre = new GridBagConstraints();
		cCheckBoxFiltre.gridx = 2;
		cCheckBoxFiltre.gridwidth = 2;
		cCheckBoxFiltre.gridy = 0;
		cbFiltre.addActionListener( (e) -> utiliseFiltre = cbFiltre.isSelected() );
		panneauSouth.add( cbFiltre, cCheckBoxFiltre );
		
		
		GridBagConstraints cLabelAttack = new GridBagConstraints();
		cLabelAttack.gridx = 2;
		cLabelAttack.gridy = 1;
		panneauSouth.add( new JLabel( "Attaque " ), cLabelAttack );
		
		JSlider sAttack = new JSlider( 0, 100, 10 );
		GridBagConstraints cSliderAttack = new GridBagConstraints();
		cSliderAttack.gridx = 3;
		cSliderAttack.gridy = 1;
		sAttack.addChangeListener( (e) -> filtreA = sAttack.getValue() / 100.0 );
		panneauSouth.add( sAttack, cSliderAttack );
		
		GridBagConstraints cLabelDecay = new GridBagConstraints();
		cLabelDecay.gridx = 2;
		cLabelDecay.gridy = 2;
		panneauSouth.add( new JLabel( "Chute " ), cLabelDecay );
		
		JSlider sDecay = new JSlider( 0, 100, 30 );
		GridBagConstraints cSliderDecay = new GridBagConstraints();
		cSliderDecay.gridx = 3;
		cSliderDecay.gridy = 2;
		sDecay.addChangeListener( (e) -> filtreD = sDecay.getValue() / 100.0 );
		panneauSouth.add( sDecay, cSliderDecay );
		
		GridBagConstraints cLabelSustain = new GridBagConstraints();
		cLabelSustain.gridx = 2;
		cLabelSustain.gridy = 3;
		panneauSouth.add( new JLabel( "Entretien " ), cLabelSustain );
		
		JSlider sSustain = new JSlider( 0, 100, 50 );
		GridBagConstraints cSliderSustain = new GridBagConstraints();
		cSliderSustain.gridx = 3;
		cSliderSustain.gridy = 3;
		sSustain.addChangeListener( (e) -> filtreS = sSustain.getValue() / 100.0 );
		panneauSouth.add( sSustain, cSliderSustain );
		
		GridBagConstraints cLabelRelease = new GridBagConstraints();
		cLabelRelease.gridx = 2;
		cLabelRelease.gridy = 4;
		panneauSouth.add( new JLabel( "Extinction " ), cLabelRelease );
		
		JSlider sRelease = new JSlider( 0, 100, 10 );
		GridBagConstraints cSliderRelease = new GridBagConstraints();
		cSliderRelease.gridx = 3;
		cSliderRelease.gridy = 4;
		sRelease.addChangeListener( (e) -> filtreR = sRelease.getValue() / 100.0 );
		panneauSouth.add( sRelease, cSliderRelease );

		add( panneauSouth, BorderLayout.SOUTH );

		/**
		 * Afficher la fenetre.
		 */
		
		setVisible(true);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater( () -> new PdemoS() );
	}	
}
