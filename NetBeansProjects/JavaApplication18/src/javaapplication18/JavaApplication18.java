import javax.swing.*;
import java.awt.event.*;

public class SquareCalculator {
    private JFrame frame;
    private JTextField textField;
    private JButton button;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SquareCalculator window = new SquareCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SquareCalculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 50, 200, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        button = new JButton("Calcular cuadrado");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textField.getText());
                int square = num * num;
                JOptionPane.showMessageDialog(null, "El cuadrado de " + num + " es " + square);
            }
        });
        button.setBounds(50, 100, 200, 30);
        frame.getContentPane().add(button);
    }
}