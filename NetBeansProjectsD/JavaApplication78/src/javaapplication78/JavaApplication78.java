
import java.awt.*;
import javax.swing.JFrame;



/**
 *
 * @author 52449
 */
public class JavaApplication78 {
public class Corazon extends JFrame {
    public Corazon() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.RED);
        g2.drawOval(50, 70, 50, 50);
        g2.drawOval(100, 70, 50, 50);
        g2.drawLine(50, 110, 100, 150);
        g2.drawLine(150, 110, 100, 150);
    }
}
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
