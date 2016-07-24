import javax.swing.*;
import java.awt.*;

public class Calculer extends JFrame {
  // Constantes
  private static final double TPS = 0.05;
  private static final double TVQ = 0.075;

  private static final int LARGEUR_FENETRE = 350;
  private static final int HAUTEUR_FENETRE = 160;
  private static final String CALCULER = "Calculer";
  public static final int MARGE_GAUCHE_1 = 10;
  public static final int MARGE_HAUT_1 = 10;
  public static final int MARGE_GAUCHE_2 = 100;
  public static final int MARGE_HAUT_2 = 40;
  private static final int MARGE_HAUT_3 = 70;
  public static final int MARGE_GAUCHE_3 = 200;
  public static final int MARGE_GAUCHE_4 = 250;
  public static final int MONTANT_INVALIDE = -1;

  // Widgets
  private JLabel labelMontant = new JLabel("Montant:");
  private JLabel labelTPS = new JLabel("TPS:");
  private JLabel labelTVQ = new JLabel("TVQ:");
  private JLabel labelTotal = new JLabel("Total:");

  private JTextField textFieldMontant = new JTextField();
  private JTextField textFieldTPS = new JTextField();
  private JTextField textFieldTVQ = new JTextField();
  private JTextField textFieldTotal = new JTextField();

  private JButton buttonCalculer = new JButton(CALCULER);

  private Calculer() {
    initVue();
    addActionListeners();
  } // Calculer()

  /**
   * Afifche un dialogue indiquant que la date entree est invalide.
   */
  public void dialogueMontantInvalide() {
    JOptionPane.showMessageDialog(this, "Montant invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
  } // dialogueMontantInvalide()

  /**
   * Construit l'interface graphique.
   */
  private void initVue() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
    setTitle(CALCULER);
    setLayout(null);

    add(labelMontant);
    add(labelTPS);
    add(labelTVQ);
    add(labelTotal);

    add(textFieldMontant);
    add(textFieldTPS);
    add(textFieldTVQ);
    add(textFieldTotal);

    add(buttonCalculer);

    // Labels
    Insets insets = getInsets();
    Dimension size = labelMontant.getPreferredSize();
    labelMontant.setBounds(MARGE_GAUCHE_1 + insets.left, MARGE_HAUT_1 + insets.top, size.width, size.height);

    size = labelTPS.getPreferredSize();
    labelTPS.setBounds(MARGE_GAUCHE_1 + insets.left, MARGE_HAUT_2 + insets.top, size.width, size.height);

    size = labelTVQ.getPreferredSize();
    labelTVQ.setBounds(MARGE_GAUCHE_1 + insets.left, MARGE_HAUT_3 + insets.top, size.width, size.height);

    // TextFields
    textFieldMontant.setBounds(MARGE_GAUCHE_2 + insets.left, MARGE_HAUT_1 + insets.top,
        labelMontant.getWidth(), labelMontant.getHeight());
    textFieldTPS.setBounds(MARGE_GAUCHE_2 + insets.left, MARGE_HAUT_2 + insets.top,
        labelMontant.getWidth(), labelMontant.getHeight());
    textFieldTVQ.setBounds(MARGE_GAUCHE_2 + insets.left, MARGE_HAUT_3 + insets.top,
        labelMontant.getWidth(), labelMontant.getHeight());

    // Section Total
    size = labelTotal.getPreferredSize();
    labelTotal.setBounds(MARGE_GAUCHE_3 + insets.left, MARGE_HAUT_1 + insets.top, size.width, size.height);

    textFieldTotal.setBounds(MARGE_GAUCHE_4 + insets.left, MARGE_HAUT_1 + insets.top, labelTotal.getWidth() * 2, labelTotal.getHeight());

    buttonCalculer.setBounds(MARGE_GAUCHE_3 + insets.left, MARGE_HAUT_2 + insets.top,
        labelTotal.getWidth() + textFieldTotal.getWidth() + 30, labelTotal.getHeight());

    textFieldTPS.setEnabled(false);
    textFieldTVQ.setEnabled(false);
    textFieldTotal.setEnabled(false);
  } // initVue()

  private void addActionListeners() {
    buttonCalculer.addActionListener(e -> {
      calulerMontant();
    });
  } // addActionListeners()

  private void calulerMontant() {
    double montant = validerMontant();
    if (montant != MONTANT_INVALIDE) {
      double montantTps = montant * TPS;
      double montantTvq = (montant + montantTps) * TVQ;
      double montantTotal = montant + montantTps + montantTvq;

      textFieldTPS.setText(String.valueOf(montantTps));
      textFieldTVQ.setText(String.valueOf(montantTvq));
      textFieldTotal.setText(String.valueOf(montantTotal));
    } else {
      dialogueMontantInvalide();
    } // else
  } // calculerMontant()

  private double validerMontant() {
    try {
      double montant = Double.parseDouble(textFieldMontant.getText());
      if (montant >= 0) {
        return montant;
      } else {
        return MONTANT_INVALIDE;
      } // else
    } catch (NumberFormatException e) {
      return MONTANT_INVALIDE;
    } // catch
  } // validerMontant()

  public static void main(String[] args) {
    Calculer calculer = new Calculer();
    calculer.setVisible(true);
  } // main()
} // Calculer