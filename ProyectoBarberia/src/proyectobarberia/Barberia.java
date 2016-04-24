
package proyectobarberia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;






public class Barberia {
	private String nombre;
	private String telefono;
	private Map<Integer,Map> horario;
	private ArrayList<Cliente> clientes;
	private ArrayList<Cliente> listaEspera;
	private ArrayList<Cita> citas;
	private ArrayList<Servicio> servicios;
	public Configuracion configuracion;
        private static Barberia instance = new Barberia();
        private String correoBarberia;
        private String passCorreo;
        
	private Barberia() {
            clientes = new ArrayList();
            listaEspera = new ArrayList();
            servicios = new ArrayList();
            citas = new ArrayList();
            
	}
	
	public static Barberia getInstance() {
            return instance;
	}
	
	public void crearCliente(String nombre, String telefono, String correo) {
            clientes.add(new Cliente(nombre, correo, telefono)); 
	}
	
	public Cliente consultarCliente(int indice) {
            return clientes.get(indice);
	}
	
	public void crearCita(LocalDate fecha,  int hora,  Cliente cliente,  Servicio servicio) {
            citas.add(new Cita(fecha, hora, servicio, cliente));
            
	}
	
	public void borrarCita( Cita cita) {
            citas.remove(cita);
	}
	
	public Cita consultarCita(int indice) {
            return citas.get(indice);
            
	}
	
	public void enviarNotificacion(Cita cita) {
            String destinatario = cita.getCliente().getCorreo();
            String asunto = "Barberia: Confirmar cita";
            String mensaje = "Le recuerdamos que usted tiene una cita el dia "+ cita.getFecha() + 
                             " a las " + cita.getHora() + ":00 horas." + "\nPara confirmar su asistencia por favor responda este correo.";
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
	
	public void agregarClienteListaEspera(Cliente cliente) {
            listaEspera.add(cliente);
            
	}
	
	public void borrarClienteListaEspera(Cliente cliente) {
            listaEspera.remove(cliente);
            
	}
	
	public void establecerHorarioAtencion(Map<Integer, Map> horario) {
            
            
	}
	
	public boolean comprobarCorreo(String correo) {
            return true;
	}
	
	public boolean comprobarTelefono(String telefono) {
            return true;
	}
        
        private static Cita buscarCita(Cita cita, ArrayList citas){
            Iterator<Cita> iter = citas.iterator();
            Cita c;
            while (iter.hasNext()){
                c= iter.next();
                if (c == cita){
                    return c;
                }
            }
            return null; 
        } 
}