/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JOptionPane;
import Clases.Barberia;
import Clases.Cliente;

/**
 *
 * @author Anthony
 */
public class VentanaAgregarCliente extends javax.swing.JDialog {

    /**
     * Creates new form VentanaAgregarCliente
     */
    
    private final boolean agregar;
    Cliente cliente;
    
    
    public VentanaAgregarCliente(java.awt.Dialog parent, boolean modal, boolean agregar, Cliente cliente) {
        super(parent, modal);
        initComponents();
        
        
        
        this.agregar = agregar;
        this.cliente = cliente;
        
        
        if(agregar){
            lblDescripcion.setText("Agregar nuevo cliente");
            
            btnAccion.setText("Agregar cliente");
            
            
        }
        
        else{
            lblDescripcion.setText("Editar cliente existente");
            
            btnAccion.setText("Editar cliente");
            
            txfNombre.setText(cliente.getNombre());
            txfTelefono.setText(cliente.getTelefono());
            txfCorreo.setText(cliente.getCorreo());
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescripcion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        txfCorreo = new javax.swing.JTextField();
        btnAccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDescripcion.setText("Descripcion");

        jLabel1.setText("Correo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Teléfono");

        txfNombre.setToolTipText("Ej: Juan Pérez");
        txfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreActionPerformed(evt);
            }
        });
        txfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreKeyTyped(evt);
            }
        });

        txfTelefono.setToolTipText("Ej: ####-####");
        txfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefonoActionPerformed(evt);
            }
        });
        txfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefonoKeyTyped(evt);
            }
        });

        txfCorreo.setToolTipText("Ej: correo@ejemplo.com");
        txfCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCorreoActionPerformed(evt);
            }
        });
        txfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCorreoKeyTyped(evt);
            }
        });

        btnAccion.setText("Agregar");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAccion)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnAccion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreActionPerformed

    private void txfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefonoActionPerformed

    private void txfCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorreoActionPerformed

    
    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        // TODO add your handling code here:
        
        if(agregar){
            boolean correoEquivalente;
            correoEquivalente = false;
            
            for(Cliente elemento : Barberia.getInstance().getClientes()){
                if(elemento.getCorreo().equals(txfCorreo.getText())){
                    correoEquivalente=  true;
                }
            }
            
            if(correoEquivalente){
                JOptionPane.showMessageDialog(null,"El correo de este cliente ya está registrado","Error al agregar nuevo cliente",0);
            }
            else{
                
                if(Barberia.getInstance().comprobarTelefono(txfTelefono.getText())){
                    if(Barberia.getInstance().comprobarCorreo(txfCorreo.getText())){
                        Barberia.getInstance().crearCliente(txfNombre.getText(), txfTelefono.getText(), txfCorreo.getText());
                        dispose();
                        JOptionPane.showMessageDialog(null, "Nuevo cliente creado: " + txfNombre.getText(),"Cliente creado exitosamente",0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/persona.png"))); //-------
                    }
                    else{
                        //El correo no funciona
                        JOptionPane.showMessageDialog(null,"Debe ingresar un correo electrónico válido","Error de correo electrónico",0);
                    }
                }
                else{
                    //El teléfono no esta bien escrito
                    JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono válido","Error de teléfono",0);
                }
                
            }
            
        
        }
        
        else{
            if (Barberia.getInstance().comprobarTelefono(txfTelefono.getText())){
                if(Barberia.getInstance().comprobarCorreo(txfCorreo.getText())){
                    cliente.setNombre(txfNombre.getText());
                    cliente.setTelefono(txfTelefono.getText());
                    cliente.setCorreo(txfCorreo.getText());
                    dispose();
                 
                }else{
                    JOptionPane.showMessageDialog(null, "Correo invalido", "Error de correo", 0);
                }
               
            }else{
                JOptionPane.showMessageDialog(null, "Teléfono invalido", "Error de teléfono", 0);
            }
           
        }
    }//GEN-LAST:event_btnAccionActionPerformed

    private void txfCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCorreoKeyTyped
        // TODO add your handling code here:
        
        if(evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
            
        
            if(agregar){
                boolean correoEquivalente;
                correoEquivalente = false;

                for(Cliente elemento : Barberia.getInstance().getClientes()){
                    if(elemento.getCorreo().equals(txfCorreo.getText())){
                        correoEquivalente=  true;
                    }
                }

                if(correoEquivalente){
                    JOptionPane.showMessageDialog(null,"El correo de este cliente ya está registrado","Error al agregar nuevo cliente",0);
                }
                else{

                    if(Barberia.getInstance().comprobarTelefono(txfTelefono.getText())){
                        if(Barberia.getInstance().comprobarCorreo(txfCorreo.getText())){
                            Barberia.getInstance().crearCliente(txfNombre.getText(), txfTelefono.getText(), txfCorreo.getText());
                            dispose();
                            JOptionPane.showMessageDialog(null, "Nuevo cliente creado: " + txfNombre.getText(),"Cliente creado exitosamente",0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/persona.png"))); //-------
                        }
                        else{
                            //El correo no funciona
                            JOptionPane.showMessageDialog(null,"Debe ingresar un correo electrónico válido","Error de correo electrónico",0);
                        }
                    }
                    else{
                        //El teléfono no esta bien escrito
                        JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono válido","Error de teléfono",0);
                    }

                }


            }

            else{

                cliente.setNombre(txfNombre.getText());
                cliente.setTelefono(txfTelefono.getText());
                cliente.setCorreo(txfCorreo.getText());
                dispose();

            }
        }
    }//GEN-LAST:event_txfCorreoKeyTyped

    private void txfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoKeyTyped
        // TODO add your handling code here:
        
        if(evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
            if(agregar){
                boolean correoEquivalente;
                correoEquivalente = false;

                for(Cliente elemento : Barberia.getInstance().getClientes()){
                    if(elemento.getCorreo().equals(txfCorreo.getText())){
                        correoEquivalente=  true;
                    }
                }

                if(correoEquivalente){
                    JOptionPane.showMessageDialog(null,"El correo de este cliente ya está registrado","Error al agregar nuevo cliente",0);
                }
                else{

                    if(Barberia.getInstance().comprobarTelefono(txfTelefono.getText())){
                        if(Barberia.getInstance().comprobarCorreo(txfCorreo.getText())){
                            Barberia.getInstance().crearCliente(txfNombre.getText(), txfTelefono.getText(), txfCorreo.getText());
                            dispose();
                            JOptionPane.showMessageDialog(null, "Nuevo cliente creado: " + txfNombre.getText(),"Cliente creado exitosamente",0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/persona.png"))); //-------
                        }
                        else{
                            //El correo no funciona
                            JOptionPane.showMessageDialog(null,"Debe ingresar un correo electrónico válido","Error de correo electrónico",0);
                        }
                    }
                    else{
                        //El teléfono no esta bien escrito
                        JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono válido","Error de teléfono",0);
                    }

                }


            }

            else{

                cliente.setNombre(txfNombre.getText());
                cliente.setTelefono(txfTelefono.getText());
                cliente.setCorreo(txfCorreo.getText());
                dispose();

            }
        }
    }//GEN-LAST:event_txfTelefonoKeyTyped

    private void txfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreKeyTyped
        // TODO add your handling code here:
        
        if(evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
            
        
            if(agregar){
                boolean correoEquivalente;
                correoEquivalente = false;

                for(Cliente elemento : Barberia.getInstance().getClientes()){
                    if(elemento.getCorreo().equals(txfCorreo.getText())){
                        correoEquivalente=  true;
                    }
                }

                if(correoEquivalente){
                    JOptionPane.showMessageDialog(null,"El correo de este cliente ya está registrado","Error al agregar nuevo cliente",0);
                }
                else{

                    if(Barberia.getInstance().comprobarTelefono(txfTelefono.getText())){
                        if(Barberia.getInstance().comprobarCorreo(txfCorreo.getText())){
                            Barberia.getInstance().crearCliente(txfNombre.getText(), txfTelefono.getText(), txfCorreo.getText());
                            dispose();
                            JOptionPane.showMessageDialog(null, "Nuevo cliente creado: " + txfNombre.getText(),"Cliente creado exitosamente",0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/persona.png"))); //-------
                        }
                        else{
                            //El correo no funciona
                            JOptionPane.showMessageDialog(null,"Debe ingresar un correo electrónico válido","Error de correo electrónico",0);
                        }
                    }
                    else{
                        //El teléfono no esta bien escrito
                        JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono válido","Error de teléfono",0);
                    }

                }


            }

            else{
                cliente.setNombre(txfNombre.getText());
                cliente.setTelefono(txfTelefono.getText());
                cliente.setCorreo(txfCorreo.getText());
                dispose();

            }
        }   
    }//GEN-LAST:event_txfNombreKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaAgregarCliente dialog = new VentanaAgregarCliente(new javax.swing.JDialog(), true,true, null);
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
    private javax.swing.JButton btnAccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JTextField txfCorreo;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables
}
