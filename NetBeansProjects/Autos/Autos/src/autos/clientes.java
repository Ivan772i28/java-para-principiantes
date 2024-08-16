package autos;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import autos.Main.*;

public class clientes extends javax.swing.JFrame {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    /** Creates new form clientes */
    public clientes() {
        initComponents();
        String Titulos[]={"DNI","Cliente","Direccion","Telefono"};
        dtm.setColumnIdentifiers(Titulos);
        tbcliente.setModel(dtm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtdir = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 50, 253));
        jLabel1.setText("Autos Premier");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 310, 10));

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 2, 11)); // NOI18N
        jLabel3.setText("El placer sobre ruedas... ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Nombres:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel10.setText("Apellidos:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel11.setText("Telefono:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel14.setText("Dirección:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 130, -1));
        jPanel2.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 130, -1));
        jPanel2.add(txtdir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 330, -1));
        jPanel2.add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, -1));

        jLabel12.setText("DNI:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel2.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 130, -1));

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, 20));

        btnver.setText("Ver Lista");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });
        jPanel2.add(btnver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 440, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 20));

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        jPanel3.add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 20));

        btncancelar.setText("  Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        btneditar.setText("  Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jPanel3.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 470, 40));

        tbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbcliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed


        int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿Desea Grabar el Registro?", "Pregunta", 0);
        if (resp == 0) {
            try {
                conn = Main.Enlace(conn);
                st = Main.sta(st);
                rs = Main.Enlcliente(rs);
                String nom,ape,dni,dir,tel;
                nom = txtnombre.getText();
                ape = txtapellidos.getText();
                dni = txtdni.getText();
                dir = txtdir.getText();
                tel = txttel.getText();
                PreparedStatement graba = conn.prepareStatement("{call graba_cliente(?,?,?,?,?)}");

                graba.setString(1, dni);
                graba.setString(2, nom);
                graba.setString(3, ape);
                graba.setString(4, dir);
                graba.setString(5, tel);
                graba.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente registrado con Exito");
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en BD" + e.toString());
            }
        }                    // TODO add your handling code here:

    }//GEN-LAST:event_btngrabarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        int resp;
        resp=JOptionPane.showConfirmDialog(null,"¿Desea Cancelar el Proceso?","Pregunta", 0);
      /* if(resp==0) {
            limpiar();
            txtcodigo.setEnabled(true);
            activabotones(true,false,false,false);
            cajastexto(false,false,false,false,false,false,false);
        }*/            // TODO add your handling code here:
}//GEN-LAST:event_btncancelarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        int resp;
        resp=JOptionPane.showConfirmDialog(null,"¿Desea Modificar los Datos?","Pregunta", 0);
        if (resp==0) {
            try {
                conn=Main.Enlace(conn);
                st=Main.sta(st);
                rs=Main.Enlcliente(rs);

                String  nom,ape,dni,dir,tel;

                dni=txtdni.getText();
                nom=txtnombre.getText();
                ape=txtapellidos.getText();
                dir=txtdir.getText();
                tel=txttel.getText();

                PreparedStatement modifica=conn.prepareStatement("{call edita_cliente(?,?,?,?,?)}");
               
                modifica.setString(1, dni);
                modifica.setString(2, nom);
                modifica.setString(3, ape);
                modifica.setString(4, dir);
                modifica.setString(5, tel);

                modifica.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos modificados con Exito");
                conn.close();

            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Error en BD"+ e.toString());
            }}                      // TODO add your handling code here:
}//GEN-LAST:event_btneditarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String b;
        if (btnagregar.isEnabled()) {
            try {
                conn=Main.Enlace(conn);
                rs=Main.Enlcliente(rs);
                b=txtdni.getText();
                boolean encuentra=false;
                String pos;
                while(rs.next()) {
                    if(b.equals(rs.getString(1))) {
                        txtnombre.setText((String)rs.getString(2));
                        txtapellidos.setText((String)rs.getString(3));
                        txtdir.setText((String)rs.getString(4));
                        txttel.setText((String)rs.getString(5));
                        encuentra=true;
                        break;
                    }
                }
                if(encuentra==false) {
                    txtdni.setText("No existe");
                    txtdni.requestFocus();
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null,"Error BD"+ e.getMessage());
            }
        }        // TODO add your handling code here:
}//GEN-LAST:event_btnbuscarActionPerformed

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
        try {
            int f, i;
            conn=Main.Enlace(conn);
            rs=Main.Enlcliente(rs);
            String datos[]=new String[5];
            f=dtm.getRowCount();
            if(f>0)
                for(i=0;i<f;i++)
                    dtm.removeRow(0);
            while(rs.next()) {
                datos[0]=(String)rs.getString(1);
                datos[1]=(String)rs.getString(2)+' '+(String)rs.getString(3);
                datos[2]=(String)rs.getString(4);
                datos[3]=(String)rs.getString(5);
                dtm.addRow(datos);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error en BD "+e.toString());
        }        // TODO add your handling code here:
}//GEN-LAST:event_btnverActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbcliente;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables

}
