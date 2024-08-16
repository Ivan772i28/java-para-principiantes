*/import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcular extends JFrame {
    private JTextField nombreField, salarioBaseField, aniosServicioField;
    private JLabel gananciasLabel;

    public Calcular() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Salario base:"));
        salarioBaseField = new JTextField();
        add(salarioBaseField);

        add(new JLabel("Años de servicio:"));
        aniosServicioField = new JTextField();
        add(aniosServicioField);

        JButton calcularButton = new JButton("Calcular ganancias");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double salarioBase = Double.parseDouble(salarioBaseField.getText());
                int aniosServicio = Integer.parseInt(aniosServicioField.getText());

                Empleado empleado = new Empleado(nombre, salarioBase, aniosServicio);
                double ganancias = empleado.calcularGanancias();

                gananciasLabel.setText("Las ganancias del empleado " + nombre + " son: " + ganancias);
            }
        });
        add(calcularButton);

        gananciasLabel = new JLabel("");
        add(gananciasLabel);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calcular().setVisible(true);
            }
        });
    }
}

  
    
   