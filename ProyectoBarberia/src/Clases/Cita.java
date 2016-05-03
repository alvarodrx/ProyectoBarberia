/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author CAMILA
 */
public class Cita implements java.io.Serializable{
    private LocalDate fecha;
    private int hora;
    private boolean confirmado = false;
    private Servicio servicio;
    private Cliente cliente;

    
    public Cita(LocalDate fecha, int hora, Servicio servicio, Cliente cliente){
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.cliente = cliente;
        
    } 
            
    public LocalDate getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public void cambiarServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void cambiarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
 
    public String toString(){
        String info = "Fecha: " + fecha + "\n" + "Hora: " + hora + "\n" + "Confirmado: " + confirmado + "Servicio brindado: " + servicio + "\n" + "Nombre del cleinte: " + cliente; 
        return info;
    }

   
    
}


