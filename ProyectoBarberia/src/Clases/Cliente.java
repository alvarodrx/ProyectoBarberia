package Clases;
import java.util.ArrayList;


public class Cliente implements java.io.Serializable{
	private String nombre;
	private String correo;
	private String telefono;
	private ArrayList <Cita> citas;

    
    public Cliente(String nombre, String correo, String telefono){
        this.nombre= nombre;
        this.correo = correo;
        this.telefono = telefono;
        citas = new ArrayList();
        
    }
        
   
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
        
} 
