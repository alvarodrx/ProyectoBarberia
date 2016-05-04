package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuracion implements java.io.Serializable{
    Barberia barberia;
	public void Configuracion() {
            
	}
	
	public void guardarDatos(){
            barberia  = Barberia.getInstance();
            try{
                FileOutputStream fos = new FileOutputStream("fichero.bin");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(barberia);
                out.close();
                System.out.println("Se guardó la clase");
            } catch (FileNotFoundException ex) {
                System.out.println("No existe el fichero");

        } catch (IOException ex) {
                System.out.println("Error IO");
        }
            
	}
        public Barberia cargarDatos(){
            try{
                FileInputStream fis = new FileInputStream("fichero.bin");
                ObjectInputStream in = new ObjectInputStream(fis);
                Barberia barberiaCargada = (Barberia) in.readObject();
                in.close();
                System.out.println("Se cargó correctamente la clase");
                return barberiaCargada;
            }catch(FileNotFoundException e){
                System.out.println("Error, no encontró archivo");
                return null;
            } catch (ClassNotFoundException ex) {
                System.out.println("Error ClassNotFound");
                return null;
            } catch (IOException ex) {
                System.out.println("Error IO");
                return null;
            }
            
        }
}
