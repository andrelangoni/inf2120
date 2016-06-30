import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIEx2 {
  static public JLabel label = new JLabel("Bonjour...");

  public static void main(String[] args) {
    SwingUtilities.invokeLater(GUIEx2::creerInterface);
  } // main()

  public static void creerInterface() {
    JFrame frame = new JFrame("Bonjour");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2,2));
    frame.add(label);

    JTextField textField = new JTextField();
    textField.addActionListener((ActionEvent e) -> label.setText(textField.getText()));
    //textField.getDocument().getText(0, textField.getDocument().getLength());

    JButton button = new JButton("effacer");
    button.addActionListener((ActionEvent e) -> label.setText(""));

    frame.add(textField);
    frame.add(button);
    frame.pack();
    frame.setVisible(true);
  } // creerInterface()
} // GUIEx
