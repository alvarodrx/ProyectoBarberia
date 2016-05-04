/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author alvar_000
 */
public class Mail implements java.io.Serializable{
    
    private Properties props = new Properties();
    Session session;    
    MimeMessage message;

    public Mail(String usuario) {
        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");

        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");

        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");

        // Nombre del usuario
        props.setProperty("mail.smtp.user", usuario);

        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");
        
        session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        message = new MimeMessage(session);
    }
    
    public void enviarCorreo(String usuario, String contraseña,String destino, String asunto, String mensaje) throws MessagingException{
        // Quien envia el correo
        message.setFrom(new InternetAddress(usuario));

        // A quien va dirigido
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
        
        // Se establece el mensaje
        message.setText(mensaje);
        
        // Se establece el asunto
        message.setSubject(asunto);
        
        // Se establece el protocolo a utilizar
        Transport t = session.getTransport("smtp");
        
        // Se establece la conexión, dando el nombre de usuario y password.
        t.connect(usuario, contraseña);

        // Enviamos el mensaje
        t.sendMessage(message,message.getAllRecipients());
                
        //Cerramos la coneccion
        t.close();
        
        
    }

    
        

}
