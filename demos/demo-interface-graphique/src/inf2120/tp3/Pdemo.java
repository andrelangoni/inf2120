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

    // region #2 JPopupMenu pour choisir le type d'onde
    JPopupMenu menu = new JPopupMenu();

    JMenu menu1 = new JMenu("type 1");
    JMenu menu2 = new JMenu("type 2");

    for (TypeOnde type : TypeOnde.values()) {
      JMenuItem item1 = new JMenuItem(type.name());
      JMenuItem item2 = new JMenuItem(type.name());

      setupItemType(item1, type, panel3, ecran, indexType1);
      setupItemType(item2, type, panel4, ecran, indexType2);

      menu1.add(item1);
      menu2.add(item2);
    } // for

    menu.add(menu1);
    menu.add(menu2);
    // endregion

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

    // region #1 bouton qui joue le son
    JButton bouton = new JButton("Joue");
    bouton.addActionListener((ActionEvent e) -> rafraichir(ecran));
    // endregion

    // region #3 choix du ratio des ondes
    JLabel label1 = new JLabel("ratio 1");
    JTextField textField1 = new JTextField();
    setupTextFieldRatio(textField1, ecran, indexType1);

    JLabel label2 = new JLabel("ratio 2");
    JTextField textField2 = new JTextField();
    setupTextFieldRatio(textField2, ecran, indexType2);
    // endregion

    // region #4 JCheckBox utilise 2 ondes
    JCheckBox checkBoxOndes = new JCheckBox("utilise deux ondes", true);
    checkBoxOndes.addActionListener((ActionEvent e) -> {
      utilise2Ondes = checkBoxOndes.isSelected();
      rafraichir(ecran);
    }); // fonction
    // endregion

    // region #5 JSlider ratio entre les deux ondes
    JLabel labelRatio = new JLabel("ratio volume (%)");
    JSlider sliderRatio = new JSlider(JSlider.HORIZONTAL, RATIO_MIN, RATIO_MAX, (int) (ratioVolume * 100));
    sliderRatio.setMajorTickSpacing(10);
    sliderRatio.setPaintTicks(true);
    sliderRatio.setPaintLabels(true);
    sliderRatio.addChangeListener(e -> {
      // attendre que l'utilisateur a fini de choisir la valeur
      if (!sliderRatio.getValueIsAdjusting()) {
        ratioVolume = ((double) sliderRatio.getValue()) / 100;
      } // if
    }); // function()
    // endregion

    // region #6 JSlider choisir la duree
    JLabel labelDuree = new JLabel("duree (ms)");
    JSlider sliderDuree = new JSlider(JSlider.HORIZONTAL, DUREE_MIN, DUREE_MAX, (int) (duree * 1000));
    sliderDuree.setMajorTickSpacing(500);
    sliderDuree.setPaintTicks(true);
    sliderDuree.setPaintLabels(true);
    sliderDuree.addChangeListener(e -> {
      if (!sliderDuree.getValueIsAdjusting()) {
        duree = ((double) sliderDuree.getValue()) / 1000;
      } // if
    }); // function()
    // endregion

    // region #7 changer la frequence
    JLabel labelFrequence = new JLabel("frequence");
    JTextField textFieldFrequence = new JTextField();

    textFieldFrequence.addActionListener((ActionEvent e) -> {
      try {
        double freqenceLue = Double.parseDouble(textFieldFrequence.getText());
        if ((freqenceLue >= 20) && (freqenceLue <= 20000) ) {
          frequence = freqenceLue;
          rafraichir(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // fonction
    // endregion

    // region #8 JCheckBox utilise filtre
    JCheckBox checkBoxFiltre = new JCheckBox("utilise filtre", true);
    checkBoxFiltre.addActionListener((ActionEvent e) -> {
      utiliseFiltre = checkBoxFiltre.isSelected();
      rafraichir(ecran);
    }); // function()
    // endregion

    // region #9 4 filtres
    JLabel labelFiltreA = new JLabel("filtre A");
    JTextField textFieldFiltreA = new JTextField();
    setupTextFieldFiltre(textFieldFiltreA, ecran, true, filtreD);

    JLabel labelFiltreD = new JLabel("filtre D");
    JTextField textFieldFiltreD = new JTextField();
    setupTextFieldFiltre(textFieldFiltreD, ecran, false, filtreA);

    JLabel labelFiltreS = new JLabel("filtre S");
    JTextField textFieldFiltreS = new JTextField();

    textFieldFiltreS.addActionListener((ActionEvent e) -> {
      try {
        double filtreSLue = Double.parseDouble(textFieldFiltreS.getText());
        if ((filtreSLue >= 0) && (filtreSLue <= 1)) {
          filtreS = filtreSLue;
          rafraichir(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()

    JLabel labelFiltreR = new JLabel("filtre R");
    JTextField textFieldFiltreR = new JTextField();

    textFieldFiltreR.addActionListener((ActionEvent e) -> {
      try {
        double filtreRLue = Double.parseDouble(textFieldFiltreR.getText());
        if ((0 <= filtreRLue) && (filtreRLue <= duree)) {
          filtreR = filtreRLue;
          rafraichir(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()
    // endregion

    // region placer les elements dans la fenetre
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
    // endregion

    // Afficher la fenetre.
    ecran.setVisible(true);
    panel3.setVisible(false);

    rafraichir(ecran);
  } // main()

  public static void setupItemType(JMenuItem item, TypeOnde type, JPanel panel, Pdemo ecran, int index) {
    item.addActionListener(e -> {
      typeOnde[index] = type;
      rafraichir(ecran);
      // #3 activer/desactiver l'option
      if (validerType(index)) {
        panel.setVisible(true);
      } else {
        panel.setVisible(false);
      } // else
    }); // addActionListener()
  } // setupItemType()

  public static void setupTextFieldRatio(JTextField textField, Pdemo ecran, int index) {
    textField.addActionListener((ActionEvent e) -> {
      try {
        double ratio = Double.parseDouble(textField.getText());
        if ((ratio >= 0) && (ratio <= 1) ) {
          ondeRatio[index] = ratio;
          rafraichir(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // fin de la fonction anonyme
  } // setupTextFieldRatio()

  public static void setupTextFieldFiltre(JTextField textField, Pdemo ecran, boolean setFiltreA, double filtre2) {
    textField.addActionListener((ActionEvent e) -> {
      try {
        double filtreLu = Double.parseDouble(textField.getText());
        if (filtreLu + filtre2 <= duree) {
          if (setFiltreA) {
            filtreA = filtreLu;
          } else {
            filtreD = filtreLu;
          } // if
          rafraichir(ecran);
        } else {
          showDialog(ecran);
        } // else
      } catch (NumberFormatException exception) {
        showDialog(ecran);
      } // catch
    }); // function()
  } // setupTextFieldFiltre()

  private static boolean validerType(int indice) {
    return (typeOnde[indice] == TypeOnde.PULSE_GENERIQUE) || (typeOnde[indice] == TypeOnde.TRIANGLE_GENERIQUE);
  } // validerType()

  private static void showDialog(Pdemo ecran) {
    JOptionPane.showMessageDialog(ecran, "Valeur invalide", "Attention", JOptionPane.WARNING_MESSAGE);
  } // showDialog()

  private static void rafraichir(Pdemo ecran) {
    Onde onde = ecran.construireOnde();
    dessin.setFonction(onde);
    dessin.repaint();
    jouerNote(onde);
  } // boutonAppuye()

} // PDemo