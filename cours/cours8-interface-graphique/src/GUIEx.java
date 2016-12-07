import javax.swing.*;

public class GUIEx {
  public static void main(String[] args) {
    Runnable r = () -> creerInterface();

/*    Runnable r = new Runnable() {
      @Override
      public void run() {
        creerInterface();
      } // run()
    }; // Runnable()*/
    //r.run();
    SwingUtilities.invokeLater(r);
  } // main()

  public static void creerInterface() {
    JFrame frame = new JFrame("Bonjour le monde");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Bonjour...");
    frame.add(label);
    frame.pack();
    frame.setVisible(true);
  } // creerInterface()
} // GUIEx
