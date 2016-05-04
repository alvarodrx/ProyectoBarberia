/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import Clases.Barberia;
import Clases.Cita;
import Clases.Cliente;
import Clases.Servicio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar_000
 */
public class CrearCita extends javax.swing.JDialog {
    private int tabActual = 0;
    private Barberia barberia = Barberia.getInstance();
    private ArrayList <String> listaClientes;
    private Cliente clienteEscogido;
    private LocalDate fechaEscogida;
    private int hora;
    private Servicio servicioEscogido;
    

    /**
     * Creates new form CrearCita
     */
    public CrearCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listaClientes = new ArrayList();
        Iterator<Cliente> almacenar = barberia.getClientes().iterator();
        while (almacenar.hasNext()) {
            Cliente cliente = almacenar.next();
            listaClientes.add(cliente.getCorreo());
        }
        DefaultComboBoxModel boxCliente = new DefaultComboBoxModel();
        comboBoxCliente.setModel(boxCliente);
        for (String clienteC : listaClientes) {
            boxCliente.addElement(clienteC);
        }
    }
    
    private boolean disponibilidadDeHoras(int diaDeSemana){
        //Se valida que hayan horas de atencion para dicho dia
        Iterator <Map> horas = barberia.getHorario().values().iterator();
        Map horarioDia = null;
        boolean disponibilidad = false;
        for(int i = 0; i <= diaDeSemana;i++){
            horarioDia = horas.next();
        }
        for(int i=0; i<24;i++){
            //Ocupo que disponibilidad tenga un true si haya al menos un true en el map
            disponibilidad = (Boolean)horarioDia.get(i)||disponibilidad;
        }
        return disponibilidad;
    }
    
    //Devuelve la cantidad de horas de atencion en el horario
    private int cantidadCitasEnDia(int dia){
        int cantidad = 0;
        Iterator <Map> horas = barberia.getHorario().values().iterator();
        Map horarioDia = null;
        for(int i = 0; i <= dia;i++){
            horarioDia = horas.next();
        }
        for(int i=0; i<24;i++){
            //Ocupo que disponibilidad tenga un true si haya al menos un true en el map
            if((boolean)horarioDia.get(i))
                cantidad++;
        }
        return cantidad;
    }
    //Devuelve el ajuste para domingo = 0...
    //Ayuda a LocalDate para evitar desface con la implementacion del horario
    private int ajusteDeDia(int dia){
        if(dia == 7)
            dia=0;
        return dia;
    }
    
    //Devuelve true si hay al menos una cita disponible en el dia
    private boolean disponibilidadDia(LocalDate fecha){
        int cantidadCitas=0;
        boolean disponible = true; 
        int diaDeLaSemana = ajusteDeDia(fecha.getDayOfWeek().getValue());
        Iterator <Cita> citas = barberia.getCitas().iterator();
        
        //Busco en todas las existentes a la cita que haga match con la fecha
        while(citas.hasNext()){
           
           Cita actual = citas.next();
           if (actual.getFecha().equals(fecha)){
               cantidadCitas++;
           }
        }
        System.out.println("Citas en el dia= "+cantidadCitasEnDia(fecha.getDayOfWeek().getValue()-1));
        System.out.println("Apartadas:" + cantidadCitas);
        if(cantidadCitas >= cantidadCitasEnDia(fecha.getDayOfWeek().getValue()-1))
           disponible = false;
       
       return disponible;
    }
    
    private boolean disponibilidadCitas(LocalDate fecha, int hora){
        boolean disponible = true; 
        Iterator <Cita> citas = barberia.getCitas().iterator();
        System.out.println("dia: " + fecha);
        //Busco en todoas las existentes a la cita que haga match con la fecha y hora actual
        while(citas.hasNext()){
           System.out.println(""+(citas.next().getFecha()));
           Cita actual = citas.next();
           if (actual.getFecha().equals(fecha) && actual.getHora()==hora){
               disponible=false;
           }
       }
        
       return disponible;
    }
    private void llenarComboBoxHora(int dia){
        ArrayList<Integer> lista = new ArrayList();
        Iterator <Map> horas = barberia.getHorario().values().iterator();
        
        Map horarioDia = null;
        for(int i = 0; i <= dia;i++){
            horarioDia = horas.next();
        }
        
        DefaultComboBoxModel boxCliente = new DefaultComboBoxModel();
        comboBoxHora.setModel(boxCliente);
        for (int i = 0; i<24;i++) {
            if((Boolean)horarioDia.get(i)){
                boxCliente.addElement(""+i+":00");
            }
            
        }
    }
        private void llenarComboBoxServicio(){
            ArrayList<String> lista = new ArrayList();
            Iterator <Servicio> servicios = barberia.obtenerServicios().iterator();
            while (servicios.hasNext()) {
                Servicio serv = servicios.next();
                lista.add(serv.getDescripcion());
            }

            DefaultComboBoxModel boxCliente = new DefaultComboBoxModel();
            comboBoxServicio.setModel(boxCliente);
            for (String servicio : lista) {
                boxCliente.addElement(servicio);
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        comboBoxCliente = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JCalendar();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxHora = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxServicio = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crea una cita");

        jTabbedPane1.setEnabled(false);
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setRequestFocusEnabled(false);

        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel3.setText("Escoge el cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel2);

        jLabel2.setText("Escoge el dia");

        calendario.setDecorationBordersVisible(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dia", jPanel3);

        jLabel1.setText("Escoje la hora de la cita");

        comboBoxHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hora", jPanel4);

        jLabel4.setText("Elije un servicio");

        comboBoxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Servicio", jPanel5);

        jLabel6.setText("Finalizado");

        jLabel7.setText("Presione Siguiente para salir y guardar la cita");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Finalizado", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        switch (tabActual){
            case 1:
                jTabbedPane1.setSelectedIndex(0);
                tabActual = 0;
                break;
            case 2:
                jTabbedPane1.setSelectedIndex(1);
                tabActual = 1;
                break;
            case 3:
                jTabbedPane1.setSelectedIndex(2);
                tabActual = 2;
                break;
            case 4:
                jTabbedPane1.setSelectedIndex(3);
                tabActual = 3;
                break;
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        switch (tabActual){
            case 0:
                clienteEscogido = barberia.buscarCliente((String)comboBoxCliente.getSelectedItem());
                jTabbedPane1.setSelectedIndex(1);
                tabActual = 1;
                break;
            case 1:
                LocalDate fechaConvertida = calendario.getCalendar().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                //Se verifica que hayan horas de atención el dia         
                if(disponibilidadDeHoras(calendario.getCalendar().get(Calendar.DAY_OF_WEEK)-1)==false){
                    JOptionPane.showMessageDialog(null, "No hay horas de atencion en el dia de la semana seleccionado ","Revise el horario o cambie de dia" ,0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/delete.png")));
                }
                if(!disponibilidadDia(fechaConvertida)){
                    JOptionPane.showMessageDialog(null, "No hay espacio para mas citas ese dia","Revise el horario o cambie de dia" ,0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/delete.png")));
                }
                else{
                    //Se crea el comboBox de citas
                    llenarComboBoxHora(calendario.getCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    jTabbedPane1.setSelectedIndex(2);
                    tabActual = 2;
                }
                fechaEscogida = fechaConvertida;
                break;
            case 2:
                llenarComboBoxServicio();
                jTabbedPane1.setSelectedIndex(3);
                
                tabActual = 3;
                servicioEscogido = barberia.obtenerServicios().get(comboBoxServicio.getSelectedIndex());
                break;
            case 3:
                jTabbedPane1.setSelectedIndex(4);
                tabActual = 4;
                break;
            case 4:
                barberia.crearCita(fechaEscogida, hora, clienteEscogido, servicioEscogido);
                JOptionPane.showMessageDialog(null, "Se ha creado la cita exitosamente","Revise el horario o cambie de dia" ,0, new javax.swing.ImageIcon(getClass().getResource("/Íconos/delete.png")));
                this.dispose();
                break;
                
        }
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearCita dialog = new CrearCita(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSiguiente;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JComboBox comboBoxCliente;
    private javax.swing.JComboBox comboBoxHora;
    private javax.swing.JComboBox comboBoxServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
