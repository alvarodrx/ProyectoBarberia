package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;


import java.util.regex.*;


public class Barberia implements java.io.Serializable {

    private String nombre;
    private String telefono;
    private Map<Integer, Map> horario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> listaEspera;
    private ArrayList<Cita> citas;
    private ArrayList<Servicio> servicios;
    public Configuracion configuracion;
    private static Barberia instance;
    private String correoBarberia;
    private String passCorreo;


    private Barberia() {
        clientes = new ArrayList();
        listaEspera = new ArrayList();
        servicios = new ArrayList();
        citas = new ArrayList();
        configuracion = new Configuracion();
            //new VentanaPrincipal().setVisible(true);

    }

    
    

    public void setInstance(Barberia inst){
        instance = inst;
    }


    public static Barberia getInstance() {
        if(instance == null){
            instance = new Barberia();
            System.out.println("se crea la barberia");
        }
        return instance;
    }

    public void crearCliente(String nombre, String telefono, String correo) {
        clientes.add(new Cliente(nombre, correo, telefono));
    }

    public Cliente consultarCliente(int indice) {
        return clientes.get(indice);
    }

    public void crearCita(LocalDate fecha, int hora, Cliente cliente, Servicio servicio) {
        citas.add(new Cita(fecha, hora, servicio, cliente));

    }

    public void borrarCita(Cita cita) {
        citas.remove(cita);
    }

    public Cita consultarCita(int indice) {
        return citas.get(indice);

    }

    public void enviarNotificacion(Cita cita) {
        String destinatario = cita.getCliente().getCorreo();
        String asunto = "Barberia: Confirmar cita";
        String mensaje = "Le recuerdamos que usted tiene una cita el dia " + cita.getFecha()
                + " a las " + cita.getHora() + ":00 horas." + "\nPara confirmar su asistencia por favor responda este correo.";
        Mail m = new Mail(correoBarberia);
        try {
            m.enviarCorreo(correoBarberia, passCorreo, destinatario, asunto, mensaje);
        } catch (MessagingException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void confirmarCita(Cita cita) {

        Cita c = buscarCita(cita, citas);

        c.setConfirmado(true);
    }

    public void crearServicio(String descripcion) {
        servicios.add(new Servicio(descripcion));
    }

    public void borrarServicio(Servicio servicio) {
        servicios.remove(servicio);
    }

    public ArrayList<Servicio> obtenerServicios() {
        return servicios;
    }

    public void agregarClienteListaEspera(Cliente cliente) {
        listaEspera.add(cliente);

    }

    public void borrarClienteListaEspera(int indice) {
        listaEspera.remove(indice);
        
        

    }

    public void establecerHorarioAtencion(Map<Integer, Map> horario) {

    }

    
    //Valida el ingreso de datos 
    private boolean validar(String expReg, String valor){
       Pattern patron = Pattern.compile(expReg);
       Matcher encontrada = patron.matcher(valor);
       return encontrada.matches();
    }
    public boolean comprobarCorreo(String correo) {
        return validar("^[\\w-\\.]+\\@[\\w\\.-]+\\.[a-z]{2,4}$",correo);
       
    }
    

  public boolean comprobarTelefono(String telefono) {
       int cantNumTelefono;
        cantNumTelefono = telefono.length();
        if(telefono.equals("")|| cantNumTelefono < 9){
            return false;
        }else{
            return validar("[\\d{0,9}[- ]*]*\\d{0,9}", telefono)|| validar("[\\w(]+[\\d{0,9}][\\w)]+[\\d{0,9}[- ]*]*\\d{0,9}", telefono);
    
        }
}
        
   


    private static Cita buscarCita(Cita cita, ArrayList citas) {
        Iterator<Cita> iter = citas.iterator();
        Cita c;
        while (iter.hasNext()) {
            c = iter.next();
            if (c == cita) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Cliente> getListaEspera() {
        return listaEspera;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setListaEspera(ArrayList<Cliente> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public Map getHorario() {
        return horario;
    }

    public void setHorario(Map horario) {
        this.horario = horario;
    }

    public Cliente buscarCliente(String correo) {
        String correoCliente;
        for (int i = 0; i < clientes.size(); i++) {
            correoCliente = clientes.get(i).getCorreo();
            if (correoCliente.equals(correo)) {
                return clientes.get(i);
            }

        }
        return null;
    }

  
}


