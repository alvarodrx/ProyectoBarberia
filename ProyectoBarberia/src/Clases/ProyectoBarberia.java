/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Forms.VentanaPrincipal;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author CAMILA
 */
public class ProyectoBarberia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here

        Configuracion c = new Configuracion();
        Barberia barberia;
        barberia = c.cargarDatos();
        if(barberia == null){
            barberia = Barberia.getInstance();
            System.out.println("No hay archivo");
            barberia.crearCliente("Ana", "Ana.98", "correo7890098765");
        }else{
            barberia.setInstance(barberia);
            System.out.println("Se cargó el archivo");

        }
        new VentanaPrincipal().setVisible(true);
        System.out.println(barberia.comprobarTelefono("(506)8753-7822"));


        
    }
    
}
