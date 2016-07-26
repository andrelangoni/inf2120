import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BB extends JPanel implements MouseListener {
  @Override
  public void paint(Graphics g) {
    g.drawRect(10, 10, 100, 200);
    //new Rectangle(new Point(10, 10), new Dimension(100, 200)));
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    e.getX();
    e.getY();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}