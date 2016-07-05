package inf2120.tp3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("WeakerAccess")
public class Pdemo extends JFrame {
  public static final int FREQUENCE_ECHANTILLONAGE = 44100;
  public static final int NB_CANALS = 1;
  public static final int OCTETS_PAR_ECHANTILLON = 2;
  public static final int TAILLE_CADRE = NB_CANALS * OCTETS_PAR_ECHANTILLON;
  public static final int NB_OCTETS = FREQUENCE_ECHANTILLONAGE * TAILLE_CADRE;
  public static final int AMPLITUDE_MAXIMUM = (int) (Math.pow(2, OCTETS_PAR_ECHANTILLON * 8 - 1) - 1);

  public static final int RATIO_MIN = 0;
  public static final int RATIO_MAX = 100;

  public static final int DUREE_MIN = 0;
  public static final int DUREE_MAX = 2000;

  public static final int BORDURE_X = 430;
  public static final int BORDURE_Y = 450; // 120

  protected static Graphic dessin;

  private static final long serialVersionUID = 1L;

  /** Detail decrivant l'onde. */
  public enum TypeOnde {
    SINUSOIDALE, TRIANGLE, TRIANGLE_GENERIQUE, SCIED, SCIEM, CARRE, PULSE_GENERIQUE, BRUIT
  } // TypeOnde

  // Generique au son :
  // valeur entre 20 et 20000
  static double frequence = 440.0;
  // valeur entre 0 et 2
  static double duree = 1.0;

  // Ondes
  static TypeOnde typeOnde[] = {TypeOnde.SINUSOIDALE, TypeOnde.PULSE_GENERIQUE};
  static int indexType1 = 0;
  static int indexType2 = 1;
  // valeur entre 0 et 1, utilise si nous avons onde PULSE_GENERIQUE ou TRIANGLE_GENERIQUE.
  static double[] ondeRatio = {0.5, 0.7};

  // Peut etre Onde 2 :
  static boolean utilise2Ondes = true;
  // valeur entre 0 et 1
  static double ratioVolume = 0.5;

  // Filtre :
  // filtreS est enmtre 0 et 1.
  // filtreA + filtreD <= duree
  static boolean utiliseFiltre = true;
  static double filtreA = 0.1;
  static double filtreD = 0.3;
  static double filtreS = 0.5;
  static double filtreR = 0.1;

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

    JPanel panel1 = new JPanel(new GridLayout(1,2));

    JPanel panel2 = new JPanel(new GridLayout(8,1));

    JPanel panel3 = new JPanel(new GridLayout(2,1));
    JPanel panel4 = new JPanel(new GridLayout(2,1));

    JPanel panel5 = new JPanel(new GridLayout(8,1));

    JPanel panelFiltreA = new JPanel(new GridLayout(2,1));
    JPanel panelFiltreD = new JPanel(new GridLayout(2,1));
    JPanel panelFiltreS = new JPanel(new GridLayout(2,1));
    JPanel panelFiltreR = new JPanel(new GridLayout(2,1));

    JPopupMenu menu = new JPopupMenu("Type d'onde");

    JMenu menu1 = new JMenu("type 1");
    JMenu menu2 = new JMenu("type 2");

    for (TypeOnde type : TypeOnde.values()) {
      JMenuItem item1 = new JMenuItem(type.name());
      JMenuItem item2 = new JMenuItem(type.name());

      //noinspection Duplicates
      item1.addActionListener(e -> {
        typeOnde[indexType1] = type;
        boutonAppuye(ecran);
        if (validerType(indexType1)) {
          panel3.setVisible(true);
        } else {
          panel3.setVisible(false);
        } // else
      }); // addActionListener()

      //noinspection Duplicates
      item2.addActionListener(e -> {
        typeOnde[indexType2] = type;
        boutonAppuye(ecran);
        if (validerType(indexType2)) {
          panel4.setVisible(true);
        } else {
          panel4.setVisible(false);
        } // else
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

    JLabel label1 = new JLabel("ratio 1");
    JTextField textField1 = new JTextField();

    textField1.addActionListener((ActionEvent e) -> {
      try {
        double ratio1 = Double.parseDouble(textField1.getText());
        if ((ratio1 >= 0) && (ratio1 <= 1) ) {
          ondeRatio[0] = ratio1;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JLabel label2 = new JLabel("ratio 2");
    JTextField textField2 = new JTextField();

    textField2.addActionListener((ActionEvent e) -> {
      try {
        double ratio2 = Double.parseDouble(textField2.getText());
        if ((ratio2 >= 0) && (ratio2 <= 1)) {
          ondeRatio[1] = ratio2;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JCheckBox checkBoxOndes = new JCheckBox("utilise deux ondes", true);
    checkBoxOndes.addActionListener((ActionEvent e) -> {
      utilise2Ondes = checkBoxOndes.isSelected();
      boutonAppuye(ecran);
    }); // function()

    JLabel labelRatio = new JLabel("ratio volume (%)");
    JSlider sliderRatio = new JSlider(JSlider.HORIZONTAL, RATIO_MIN, RATIO_MAX, (int) (ratioVolume * 100));
    sliderRatio.setMajorTickSpacing(10);
    sliderRatio.setPaintTicks(true);
    sliderRatio.setPaintLabels(true);
    sliderRatio.addChangeListener(e -> {
      if (!sliderRatio.getValueIsAdjusting()) {
        ratioVolume = ((double) sliderRatio.getValue()) / 100;
      } // if
    }); // function()

    JLabel labelDuree = new JLabel("durée (ms)");
    JSlider sliderDuree = new JSlider(JSlider.HORIZONTAL, DUREE_MIN, DUREE_MAX, (int) (duree * 1000));
    sliderDuree.setMajorTickSpacing(500);
    sliderDuree.setPaintTicks(true);
    sliderDuree.setPaintLabels(true);
    sliderDuree.addChangeListener(e -> {
      if (!sliderDuree.getValueIsAdjusting()) {
        duree = ((double) sliderDuree.getValue()) / 1000;
      } // if
    }); // function()

    JLabel labelFrequence = new JLabel("frequence");
    JTextField textFieldFrequence = new JTextField();

    textFieldFrequence.addActionListener((ActionEvent e) -> {
      try {
        double freqenceLue = Double.parseDouble(textFieldFrequence.getText());
        if ((freqenceLue >= 20) && (freqenceLue <= 20000) ) {
          frequence = freqenceLue;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JCheckBox checkBoxFiltre = new JCheckBox("utilise filtre", true);
    checkBoxFiltre.addActionListener((ActionEvent e) -> {
      utiliseFiltre = checkBoxFiltre.isSelected();
      boutonAppuye(ecran);
    }); // function()

    // 4 filtres
    JLabel labelFiltreA = new JLabel("filtre A");
    JTextField textFieldFiltreA = new JTextField();

    //noinspection Duplicates
    textFieldFiltreA.addActionListener((ActionEvent e) -> {
      try {
        double filtreALue = Double.parseDouble(textFieldFiltreA.getText());
        if (filtreALue + filtreD <= duree) {
          filtreA = filtreALue;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JLabel labelFiltreD = new JLabel("filtre D");
    JTextField textFieldFiltreD = new JTextField();

    //noinspection Duplicates
    textFieldFiltreD.addActionListener((ActionEvent e) -> {
      try {
        double filtreDLue = Double.parseDouble(textFieldFiltreD.getText());
        if (filtreA + filtreDLue <= duree) {
          filtreD = filtreDLue;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JLabel labelFiltreS = new JLabel("filtre S");
    JTextField textFieldFiltreS = new JTextField();

    //noinspection Duplicates
    textFieldFiltreS.addActionListener((ActionEvent e) -> {
      try {
        double filtreSLue = Double.parseDouble(textFieldFiltreS.getText());
        if ((filtreSLue >= 0) && (filtreSLue <= 1)) {
          filtreS = filtreSLue;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JLabel labelFiltreR = new JLabel("filtre R");
    JTextField textFieldFiltreR = new JTextField();

    //noinspection Duplicates
    textFieldFiltreR.addActionListener((ActionEvent e) -> {
      try {
        double filtreRLue = Double.parseDouble(textFieldFiltreR.getText());
        if ((0 <= filtreRLue) && (filtreRLue <= duree)) {
          filtreR = filtreRLue;
          boutonAppuye(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    panel3.add(label1);
    panel3.add(textField1);
    panel4.add(label2);
    panel4.add(textField2);

    panel2.add(bouton);
    panel2.add(panel3);
    panel2.add(panel4);
    panel2.add(checkBoxOndes);
    panel2.add(labelRatio);
    panel2.add(sliderRatio);
    panel2.add(labelDuree);
    panel2.add(sliderDuree);

    panelFiltreA.add(labelFiltreA);
    panelFiltreA.add(textFieldFiltreA);
    panelFiltreD.add(labelFiltreD);
    panelFiltreD.add(textFieldFiltreD);
    panelFiltreS.add(labelFiltreS);
    panelFiltreS.add(textFieldFiltreS);
    panelFiltreR.add(labelFiltreR);
    panelFiltreR.add(textFieldFiltreR);

    panel5.add(labelFrequence);
    panel5.add(textFieldFrequence);
    panel5.add(checkBoxFiltre);
    panel5.add(panelFiltreA);
    panel5.add(panelFiltreD);
    panel5.add(panelFiltreS);
    panel5.add(panelFiltreR);

    panel1.add(panel2);
    panel1.add(panel5);

    ecran.add(panel1, BorderLayout.SOUTH);
    ecran.add(dessin, BorderLayout.CENTER);

    // Afficher la fenetre.
    ecran.setVisible(true);
    panel3.setVisible(false);

    boutonAppuye(ecran);
  } // main()

  private static boolean validerType(int indice) {
    return (typeOnde[indice] == TypeOnde.PULSE_GENERIQUE) || (typeOnde[indice] == TypeOnde.TRIANGLE_GENERIQUE);
  } // validerType()

  private static void showDialog(Pdemo ecran) {
    JOptionPane.showMessageDialog(ecran, "Valeur invalide", "Attention", JOptionPane.WARNING_MESSAGE);
  } // showDialog()

  private static void boutonAppuye(Pdemo ecran) {
    Onde onde = ecran.construireOnde();
    dessin.setFonction(onde);
    dessin.repaint();
    jouerNote(onde);
  } // boutonAppuye()

} // PDemo