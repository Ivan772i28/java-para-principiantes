/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corazon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author 52449
 */
public class Corazon extends JFrame  {
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
        g2.fillOval(50, 70, 50, 50);
        g2.fillOval(100, 70, 50, 50);
        int[] xPoints = {50, 100, 150};
        int[] yPoints = {110, 150, 110};
        g2.fillPolygon(xPoints, yPoints, 3);
    }
    
        
     
    public static void main(String[] args) {
    new Corazon();
}
}
