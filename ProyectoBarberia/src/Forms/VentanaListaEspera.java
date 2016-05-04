/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Clases.Cliente;
import Clases.Barberia;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;


/**
 *
 * @author CAMILA
 */
public class VentanaListaEspera extends javax.swing.JDialog {

    DefaultListModel VentanaListaEspera = new DefaultListModel();
    private Barberia barberia = Barberia.getInstance();
    private ArrayList<String> listaClientes;
    private ArrayList<String> listaCorreos;

    //constructor de ventana lista espera
  //  private VentanaListaEspera() {

    //}

    /**
     * Creates new form NewJDialog
     */
    public VentanaListaEspera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        listaClientes = new ArrayList();
        Iterator<Cliente> almacenar = barberia.getClientes().iterator();
        while (almacenar.hasNext()) {
            Cliente cliente = almacenar.next();
            listaClientes.add(cliente.getCorreo());
        }

        DefaultComboBoxModel boxCliente = new DefaultComboBoxModel();
        ComboBoxListaClientes.setModel(boxCliente);
        for (int i = 0; i < listaClientes.size(); i++) {
            String clienteC = listaClientes.get(i);
            boxCliente.addElement(clienteC);
        }
        refrescarListaEspera();

    }

    private void refrescarListaEspera() {
        DefaultListModel modeloListaCliEspera = new DefaultListModel();
        int contador = 0;
        for (Cliente cliente : barberia.getListaEspera()) {
            modeloListaCliEspera.add(contador, cliente.getCorreo());
            contador++;

        }
        TextListaClienteEspera.setModel(modeloListaCliEspera);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelListaEspera = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextListaClienteEspera = new javax.swing.JList();
        LabelNombreCliente = new javax.swing.JLabel();
        BotonAgregarCliente = new javax.swing.JButton();
        BotonEliminarCliente = new javax.swing.JButton();
        BotonVerCliente = new javax.swing.JButton();
        ComboBoxListaClientes = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelListaEspera.setText("Clientes");

        jScrollPane1.setViewportView(TextListaClienteEspera);

        LabelNombreCliente.setText("Lista de espera");

        BotonAgregarCliente.setText("+");
        BotonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarClienteActionPerformed(evt);
            }
        });

        BotonEliminarCliente.setText("-");
        BotonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarClienteActionPerformed(evt);
            }
        });

        BotonVerCliente.setText("verCliente");
        BotonVerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerClienteActionPerformed(evt);
            }
        });

        ComboBoxListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxListaClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNombreCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVerCliente)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BotonEliminarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonAgregarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelListaEspera)
                    .addComponent(ComboBoxListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LabelListaEspera)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombreCliente)
                    .addComponent(ComboBoxListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonAgregarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonEliminarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(BotonVerCliente)
                        .addContainerGap(137, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarClienteActionPerformed

        String clienteEspera = (String) ComboBoxListaClientes.getSelectedItem();
        barberia.agregarClienteListaEspera(barberia.buscarCliente(clienteEspera));
        refrescarListaEspera();
        
// TODO add your handling code here:

    }//GEN-LAST:event_BotonAgregarClienteActionPerformed

    private void ComboBoxListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxListaClientesActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxListaClientesActionPerformed

    private void BotonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarClienteActionPerformed
     // TODO add your handling code here:
        try{
            barberia.borrarClienteListaEspera(TextListaClienteEspera.getSelectedIndex());
        refrescarListaEspera();
          
     } 
        catch (Exception ex){
                 JOptionPane.showMessageDialog(null, "No hay cliente en lista de espera");

                }
    }//GEN-LAST:event_BotonEliminarClienteActionPerformed

    private void BotonVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonVerClienteActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaListaEspera dialog = new VentanaListaEspera(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarCliente;
    private javax.swing.JButton BotonEliminarCliente;
    private javax.swing.JButton BotonVerCliente;
    private javax.swing.JComboBox ComboBoxListaClientes;
    private javax.swing.JLabel LabelListaEspera;
    private javax.swing.JLabel LabelNombreCliente;
    private javax.swing.JList TextListaClienteEspera;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
