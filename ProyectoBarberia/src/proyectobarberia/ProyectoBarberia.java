/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobarberia;

import Forms.VentanaPrincipal;

/**
 *
 * @author CAMILA
 */
public class ProyectoBarberia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Barberia b = Barberia.getInstance();
        System.out.println(b.comprobarTelefono("(506)8753-7822"));
        
        b.crearCliente("Ana", "Ana.98", "correo7890098765");
        new VentanaPrincipal().setVisible(true);
       
       

       

        

        
    }
    
}
