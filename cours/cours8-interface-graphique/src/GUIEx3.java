import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIEx3 {
  static public JLabel label = new JLabel("Bonjour...");

  public static void main(String[] args) {
    SwingUtilities.invokeLater(GUIEx3::creerInterface);
  } // main()

  public static void creerInterface() {
    int rows = 5;
    JLabel label = new JLabel("Bonjour...");

    JFrame frame = new JFrame("Bonjour");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    JPanel panel = new JPanel();

    GridLayout layout = new GridLayout(rows,1);
/*    for (int i = 0; i < rows; i++) {
      layout.addLayoutComponent(String.valueOf(i), new JLabel("Bonjour " + i));
    } // for*/

    panel.setLayout(layout);
    frame.add(panel, BorderLayout.WEST);

    frame.pack();
    frame.setVisible(true);
  } // creerInterface()
} // GUIEx
