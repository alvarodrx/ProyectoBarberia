package Clases;



public class Servicio implements java.io.Serializable{
	private String descripcion;
        
	public Servicio(String descripcion) {
            this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
            return descripcion; 
	}
	
	public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
	}
}
