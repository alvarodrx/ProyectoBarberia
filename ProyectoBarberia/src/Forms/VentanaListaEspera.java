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
    public VentanaListaEspera(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
       TextListaClienteEspera.setVisible(false);
       

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

        GrupoLisEspera = new javax.swing.ButtonGroup();
        LabelCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextListaClienteEspera = new javax.swing.JList();
        LabelNombreCliente = new javax.swing.JLabel();
        BotonAgregarCliente = new javax.swing.JButton();
        BotonEliminarCliente = new javax.swing.JButton();
        BotonVerCliente = new javax.swing.JButton();
        ComboBoxListaClientes = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        rdbVerLista = new javax.swing.JRadioButton();
        rdbOcultarLista = new javax.swing.JRadioButton();
        rdbEditarLista = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelCliente.setText("Clientes");

        TextListaClienteEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextListaClienteEsperaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TextListaClienteEspera);

        LabelNombreCliente.setText("Lista de espera");

        BotonAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Íconos/add.png"))); // NOI18N
        BotonAgregarCliente.setToolTipText("Agregar cliente a lista de espera");
        BotonAgregarCliente.setEnabled(false);
        BotonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarClienteActionPerformed(evt);
            }
        });

        BotonEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Íconos/delete.png"))); // NOI18N
        BotonEliminarCliente.setToolTipText("Eliminar cliente seleccionado");
        BotonEliminarCliente.setEnabled(false);
        BotonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarClienteActionPerformed(evt);
            }
        });

        BotonVerCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Íconos/eye.png"))); // NOI18N
        BotonVerCliente.setToolTipText("Ver cliente seleccionado");
        BotonVerCliente.setEnabled(false);
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

        GrupoLisEspera.add(rdbVerLista);
        rdbVerLista.setText("Ver lista de espera");
        rdbVerLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVerListaActionPerformed(evt);
            }
        });

        GrupoLisEspera.add(rdbOcultarLista);
        rdbOcultarLista.setSelected(true);
        rdbOcultarLista.setText("Ocultar lista de espera");
        rdbOcultarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOcultarListaActionPerformed(evt);
            }
        });

        GrupoLisEspera.add(rdbEditarLista);
        rdbEditarLista.setText("Editar lista espera");
        rdbEditarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEditarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbOcultarLista)
                    .addComponent(rdbVerLista)
                    .addComponent(rdbEditarLista))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(rdbVerLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbOcultarLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbEditarLista)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(LabelNombreCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelCliente)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ComboBoxListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonVerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(BotonEliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addComponent(BotonAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                                .addGap(36, 36, 36))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente)
                    .addComponent(LabelNombreCliente))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(ComboBoxListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(BotonAgregarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonEliminarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(BotonVerCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))))
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
    BotonEliminarCliente.setEnabled(false);
    BotonVerCliente.setEnabled(false);
    rdbOcultarLista.setEnabled(true);
        try{
            barberia.borrarClienteListaEspera(TextListaClienteEspera.getSelectedIndex());
        refrescarListaEspera();
          
     } 
        catch (Exception ex){
                 JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente de la lista de espera");

                }
     
    }//GEN-LAST:event_BotonEliminarClienteActionPerformed

    private void BotonVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerClienteActionPerformed
        // TODO add your handling code here:
        new VentanaAgregarCliente(this,true,3, Barberia.getInstance().getListaEspera().get(TextListaClienteEspera.getSelectedIndex())).setVisible(true);
        
        
    }//GEN-LAST:event_BotonVerClienteActionPerformed

    private void TextListaClienteEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextListaClienteEsperaMouseClicked
        // TODO add your handling code here:
        if(rdbEditarLista.isSelected()){
            BotonVerCliente.setEnabled(true);
            BotonEliminarCliente.setEnabled(true);
            rdbOcultarLista.setEnabled(true);
            rdbVerLista.setEnabled(true);
            rdbEditarLista.setEnabled(true);
        }
        
        
        
    }//GEN-LAST:event_TextListaClienteEsperaMouseClicked

    private void rdbVerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVerListaActionPerformed
        // TODO add your handling code here:
        LabelNombreCliente.setEnabled(false);
        TextListaClienteEspera.setEnabled(false);
        rdbOcultarLista.setEnabled(true);
        TextListaClienteEspera.setVisible(true);
        LabelCliente.setEnabled(false);
        ComboBoxListaClientes.setEnabled(false);
        BotonAgregarCliente.setEnabled(false);
        BotonEliminarCliente.setEnabled(false);
        BotonVerCliente.setEnabled(false);
        
        
        
        
        
    }//GEN-LAST:event_rdbVerListaActionPerformed

    private void rdbOcultarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOcultarListaActionPerformed
        // TODO add your handling code here:
        LabelNombreCliente.setEnabled(false);
        TextListaClienteEspera.setEnabled(false);
        TextListaClienteEspera.setVisible(false);
        LabelCliente.setEnabled(true);
        ComboBoxListaClientes.setEnabled(true);
        BotonAgregarCliente.setEnabled(false);
        BotonEliminarCliente.setEnabled(false);
        BotonVerCliente.setEnabled(false);
    }//GEN-LAST:event_rdbOcultarListaActionPerformed

    private void rdbEditarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEditarListaActionPerformed
        // TODO add your handling code here:
        rdbEditarLista.setSelected(true);
        LabelNombreCliente.setEnabled(true);
        TextListaClienteEspera.setEnabled(true);
        TextListaClienteEspera.setVisible(true);
        LabelCliente.setEnabled(true);
        ComboBoxListaClientes.setEnabled(true);
        BotonAgregarCliente.setEnabled(true);
        BotonEliminarCliente.setEnabled(true);
        BotonVerCliente.setEnabled(true);
    }//GEN-LAST:event_rdbEditarListaActionPerformed

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
                VentanaListaEspera dialog = new VentanaListaEspera(new javax.swing.JDialog(), true);
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
    private javax.swing.ButtonGroup GrupoLisEspera;
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelNombreCliente;
    private javax.swing.JList TextListaClienteEspera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbEditarLista;
    private javax.swing.JRadioButton rdbOcultarLista;
    private javax.swing.JRadioButton rdbVerLista;
    // End of variables declaration//GEN-END:variables
}
