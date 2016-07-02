package inf2120.tp3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

@SuppressWarnings("WeakerAccess")
public class Pdemo extends JFrame {
  public static final int FREQUENCE_ECHANTILLONAGE = 44100;
  public static final int NB_CANALS = 1;
  public static final int OCTETS_PAR_ECHANTILLON = 2;
  public static final int TAILLE_CADRE = NB_CANALS * OCTETS_PAR_ECHANTILLON;
  public static final int NB_OCTETS = FREQUENCE_ECHANTILLONAGE * TAILLE_CADRE;
  public static final int AMPLITUDE_MAXIMUM = (int) (Math.pow(2, OCTETS_PAR_ECHANTILLON * 8 - 1) - 1);

  public static final int BORDURE_X = 430;
  public static final int BORDURE_Y = 120;

  protected static Graphic dessin;

  private static final long serialVersionUID = 1L;

  /**
   * Detail decrivant l'onde.
   */
  public enum TypeOnde {
    SINUSOIDALE, TRIANGLE, TRIANGLE_GENERIQUE, SCIED, SCIEM, CARRE, PULSE_GENERIQUE, BRUIT
  } // TypeOnde

  // Generique au son :
  // valeur entre 20 et 20000
  double frequence = 440.0;
  // valeur entre 0 et 2
  double duree = 1.0;

  // Ondes
  static TypeOnde typeOnde[] = {TypeOnde.SINUSOIDALE, TypeOnde.PULSE_GENERIQUE};
  // valeur entre 0 et 1, utilise si nous avons onde PULSE_GENERIQUE ou TRIANGLE_GENERIQUE.
  double ondeRatio[] = {0.5, 0.7};

  // Peut etre Onde 2 :
  boolean utilise2Ondes = true;
  // valeur entre 0 et 1
  double ratioVolume = 0.5;

  // Filtre :
  // filtreS est enmtre 0 et 1.
  // filtreA + filtreD <= duree
  boolean utiliseFiltre = true;
  double filtreA = 0.1;
  double filtreD = 0.3;
  double filtreS = 0.5;
  double filtreR = 0.1;

  public Onde construireOndeBase(int i) {
    Onde resultat = null;
    switch (typeOnde[i]) {
      case SINUSOIDALE:
        resultat = new Sinusoidale(FREQUENCE_ECHANTILLONAGE, frequence);
        break;
      case TRIANGLE:
        resultat = new Triangle(FREQUENCE_ECHANTILLONAGE, frequence);
        break;
      case SCIED:
        resultat = new ScieD(FREQUENCE_ECHANTILLONAGE, frequence);
        break;
      case SCIEM:
        resultat = new ScieM(FREQUENCE_ECHANTILLONAGE, frequence);
        break;
      case CARRE:
        resultat = new Carre(FREQUENCE_ECHANTILLONAGE, frequence);
        break;
      case BRUIT:
        resultat = new Bruit();
        break;
      case PULSE_GENERIQUE:
        resultat = new PulseGenerique(FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i]);
        break;
      case TRIANGLE_GENERIQUE:
        resultat = new TriangleGenerique(FREQUENCE_ECHANTILLONAGE, frequence, ondeRatio[i]);
        break;
    } // switch
    resultat.setDure(duree);
    return resultat;
  } // construireOndeBase()

  public Onde construireOnde() {
    int indexType1 = 0;
    int indexType2 = 1;

    Onde resultat = construireOndeBase(indexType1);

    if (utilise2Ondes) {
      resultat = new Mixe(resultat, ratioVolume, construireOndeBase(indexType2), 1.0 - ratioVolume);
      resultat.setDure(duree);
    } // if

    if (utiliseFiltre) {
      ADSR f = new ADSR(FREQUENCE_ECHANTILLONAGE, filtreA, filtreD, filtreS, filtreR);
      f.setDure(duree);
      resultat = new Filtre(resultat, f);
      resultat.setDure(duree);
    } // if

    return resultat;
  }  // construireOnde()

  @SuppressWarnings("UnusedAssignment")
  public static void jouerNote(Onde onde) {
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
        buffer[j] = (byte) (amp & 0xFF);
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

  public static void main(String[] args) {
    Pdemo ecran = new Pdemo();
    ecran.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ecran.setLayout(new BorderLayout());
    ecran.setSize(Graphic.TAILLE_X + BORDURE_X, 2 * Graphic.TAILLE_Y + BORDURE_Y);

    JPopupMenu menu = new JPopupMenu("Type d'onde");

    JMenu menu1 = new JMenu("type 1");
    JMenu menu2 = new JMenu("type 2");

    for (TypeOnde type : TypeOnde.values()) {
      JMenuItem item1 = new JMenuItem(type.name());
      JMenuItem item2 = new JMenuItem(type.name());

      item1.addActionListener(e -> {
        typeOnde[0] = type;
        boutonAppuye(ecran);
      }); // addActionListener()

      item2.addActionListener(e -> {
        typeOnde[1] = type;
        boutonAppuye(ecran);
      }); // addActionListener()

      menu1.add(item1);
      menu2.add(item2);
    } // for

    menu.add(menu1);
    menu.add(menu2);

     // Construire l'interface.
    dessin = new Graphic();

    dessin.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        menu.show(dessin, e.getX(), e.getY());
      } // mouseClicked()

      @Override
      public void mousePressed(MouseEvent e) {}
      @Override
      public void mouseReleased(MouseEvent e) {}
      @Override
      public void mouseEntered(MouseEvent e) {}
      @Override
      public void mouseExited(MouseEvent e) {}
    }); // addMouseListener()

    JButton bouton = new JButton("Joue");
    bouton.addActionListener((ActionEvent e) -> boutonAppuye(ecran));

    ecran.add(bouton, BorderLayout.SOUTH);
    ecran.add(dessin, BorderLayout.CENTER);

    // Afficher la fenetre.
    ecran.setVisible(true);

    boutonAppuye(ecran);
  }  // main()

  private static void boutonAppuye(Pdemo ecran) {
    Onde onde = ecran.construireOnde();
    dessin.setFonction(onde);
    dessin.repaint();
    jouerNote(onde);
  } // boutonAppuye()

  private static void setType1(TypeOnde type1) {
    typeOnde[0] = type1;
    //boutonAppuye(ecran);
  } // setType1()

} // PDemo
