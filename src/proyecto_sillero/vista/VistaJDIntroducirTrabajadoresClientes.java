/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_sillero.vista;
import java.io.IOException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import proyecto_sillero.controlador.CtrlIntroducirTrabajadoresClientes;
/**
 * Recordar: falta por controlar los errores, que el metodo del controlador devuelva un true o false y controlarlo de esa manera
 * tambien falta comprobar los campos vacios.
 * @author Rafa
 */
public class VistaJDIntroducirTrabajadoresClientes extends javax.swing.JDialog {
    
    private CtrlIntroducirTrabajadoresClientes annadirClienteTrabajadorControlador;
    /**
     * Creates new form JDialogIntroducirTrabajadoresClientes
     */
    public VistaJDIntroducirTrabajadoresClientes(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDNICliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldnHabitacionlCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldnNochesCliente = new javax.swing.JTextField();
        jButtonAnnadirCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelNombreTrabajador = new javax.swing.JLabel();
        jLabel2DNITrabajador = new javax.swing.JLabel();
        jLabelOcupacionTrabajador = new javax.swing.JLabel();
        jTextFieldNombreTrabajador = new javax.swing.JTextField();
        jTextFieldDNITrabajador = new javax.swing.JTextField();
        jTextFieldOcupacion = new javax.swing.JTextField();
        jButtonAnnadirTrabajador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVerCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEscribirClientes = new javax.swing.JTable();
        jButtonPasarAEscribirCliente = new javax.swing.JButton();
        jButtonPasarALeerCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jTextFieldNombreCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNombreCliente.setAutoscrolls(false);
        jTextFieldNombreCliente.setMinimumSize(null);
        jTextFieldNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");

        jTextFieldDNICliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldDNICliente.setAutoscrolls(false);

        jLabel3.setText("Numero de Habitacion:");

        jTextFieldnHabitacionlCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldnHabitacionlCliente.setAutoscrolls(false);

        jLabel4.setText("Numero de Noches:");

        jTextFieldnNochesCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldnNochesCliente.setAutoscrolls(false);

        jButtonAnnadirCliente.setText("Añadir");
        jButtonAnnadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnadirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButtonAnnadirCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldnHabitacionlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextFieldnNochesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldnHabitacionlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldnNochesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButtonAnnadirCliente)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jLabelNombreTrabajador.setText("Nombre:");

        jLabel2DNITrabajador.setText("DNI:");

        jLabelOcupacionTrabajador.setText("Ocupación");

        jTextFieldNombreTrabajador.setMinimumSize(null);
        jTextFieldNombreTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreTrabajadorActionPerformed(evt);
            }
        });

        jTextFieldOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOcupacionActionPerformed(evt);
            }
        });

        jButtonAnnadirTrabajador.setText("Añadir");
        jButtonAnnadirTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnadirTrabajadorActionPerformed(evt);
            }
        });

        jTableVerCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Listado Clientes"
            }
        ));
        jScrollPane1.setViewportView(jTableVerCliente);

        jTableEscribirClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Clientes Añadidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEscribirClientes);
        if (jTableEscribirClientes.getColumnModel().getColumnCount() > 0) {
            jTableEscribirClientes.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonPasarAEscribirCliente.setText(">>");
        jButtonPasarAEscribirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasarAEscribirClienteActionPerformed(evt);
            }
        });

        jButtonPasarALeerCliente.setText("<<");
        jButtonPasarALeerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasarALeerClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelOcupacionTrabajador)
                                    .addComponent(jLabel2DNITrabajador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDNITrabajador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldOcupacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelNombreTrabajador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAnnadirTrabajador)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonPasarAEscribirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPasarALeerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreTrabajador)
                    .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2DNITrabajador)
                    .addComponent(jTextFieldDNITrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOcupacionTrabajador)
                    .addComponent(jTextFieldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButtonPasarAEscribirCliente)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonPasarALeerCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButtonAnnadirTrabajador)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Trabajadores", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnadirClienteActionPerformed
        try {
            try {
                // TODO add your handling code here:
                annadirClienteTrabajadorControlador.escribirCliente();
                JOptionPane.showMessageDialog(null, "Introducido Con Éxito","Mensaje", INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null, "Error OTRA VEZ.","ERROR", ERROR_MESSAGE);
            }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Error al guardar los datos.","ERROR", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnnadirClienteActionPerformed

    private void jTextFieldNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreClienteActionPerformed

    private void jButtonAnnadirTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnadirTrabajadorActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            annadirClienteTrabajadorControlador.escribirTrabajador();
            JOptionPane.showMessageDialog(null, "Introducido Con Éxito","Mensaje", INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos.","ERROR", ERROR_MESSAGE);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos.","ERROR", ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButtonAnnadirTrabajadorActionPerformed

    private void jTextFieldOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOcupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOcupacionActionPerformed

    private void jTextFieldNombreTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreTrabajadorActionPerformed

    private void jButtonPasarAEscribirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasarAEscribirClienteActionPerformed
        annadirClienteTrabajadorControlador.pasarDeVerClienteAEscribir();
    }//GEN-LAST:event_jButtonPasarAEscribirClienteActionPerformed

    private void jButtonPasarALeerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasarALeerClienteActionPerformed
        annadirClienteTrabajadorControlador.pasarDeEscribirClienteAVer();
    }//GEN-LAST:event_jButtonPasarALeerClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaJDIntroducirTrabajadoresClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaJDIntroducirTrabajadoresClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaJDIntroducirTrabajadoresClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaJDIntroducirTrabajadoresClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaJDIntroducirTrabajadoresClientes dialog = new VistaJDIntroducirTrabajadoresClientes(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setAnnadirClienteTrabajadorControlador(CtrlIntroducirTrabajadoresClientes annadirClienteTrabajadorControlador) {
        this.annadirClienteTrabajadorControlador = annadirClienteTrabajadorControlador;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnadirCliente;
    private javax.swing.JButton jButtonAnnadirTrabajador;
    private javax.swing.JButton jButtonPasarAEscribirCliente;
    private javax.swing.JButton jButtonPasarALeerCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2DNITrabajador;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNombreTrabajador;
    private javax.swing.JLabel jLabelOcupacionTrabajador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEscribirClientes;
    private javax.swing.JTable jTableVerCliente;
    private javax.swing.JTextField jTextFieldDNICliente;
    private javax.swing.JTextField jTextFieldDNITrabajador;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldNombreTrabajador;
    private javax.swing.JTextField jTextFieldOcupacion;
    private javax.swing.JTextField jTextFieldnHabitacionlCliente;
    private javax.swing.JTextField jTextFieldnNochesCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getjTextFieldDNICliente() {
        return jTextFieldDNICliente;
    }

    public javax.swing.JTextField getjTextFieldDNITrabajador() {
        return jTextFieldDNITrabajador;
    }

    public javax.swing.JTextField getjTextFieldNombreCliente() {
        return jTextFieldNombreCliente;
    }

    public javax.swing.JTextField getjTextFieldNombreTrabajador() {
        return jTextFieldNombreTrabajador;
    }

    public javax.swing.JTextField getjTextFieldOcupacion() {
        return jTextFieldOcupacion;
    }

    public javax.swing.JTextField getjTextFieldnHotelCliente() {
        return jTextFieldnHabitacionlCliente;
    }

    public javax.swing.JTextField getjTextFieldnNochesCliente() {
        return jTextFieldnNochesCliente;
    }

    public javax.swing.JButton getjButtonPasarAEscribirCliente() {
        return jButtonPasarAEscribirCliente;
    }

    public void setjButtonPasarAEscribirCliente(javax.swing.JButton jButtonPasarAEscribirCliente) {
        this.jButtonPasarAEscribirCliente = jButtonPasarAEscribirCliente;
    }

    public javax.swing.JButton getjButtonPasarALeerCliente() {
        return jButtonPasarALeerCliente;
    }

    public void setjButtonPasarALeerCliente(javax.swing.JButton jButtonPasarALeerCliente) {
        this.jButtonPasarALeerCliente = jButtonPasarALeerCliente;
    }

    public javax.swing.JTable getjTableEscribirClientes() {
        return jTableEscribirClientes;
    }

    public void setjTableEscribirClientes(javax.swing.JTable jTableEscribirClientes) {
        this.jTableEscribirClientes = jTableEscribirClientes;
    }

    public javax.swing.JTable getjTableVerCliente() {
        return jTableVerCliente;
    }

    public void setjTableVerCliente(javax.swing.JTable jTableVerCliente) {
        this.jTableVerCliente = jTableVerCliente;
    }
    
}
