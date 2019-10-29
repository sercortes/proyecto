/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.savpro.utils;


import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;

/**
 *
 * @author smart
 */
public class Email {
    
    public String mensajeCorreo(String nombre, String correo, String password){
        return "Hola "+nombre+", Para que puedas iniciar sesión "
                + "debes el usar las siguientes credenciales:<br>"
                + "Correo: "+correo+"<br>"
                + "Contraseña: "+password+"<br>"
                + "Página del sistema http://localhost:8080/SavPro/ <br>"
                + "Recuerda que debes calificar las actividades de formación "
                + "con el fin de que puedas ser certificado. \n";
    }
   
    public boolean sendEmail(String emailTo, String mensaje){
        
        final String username = "sergio73209@gmail.com";
        
        final String password = "Sergio3105824494";
        
        String receiver = emailTo;
        
        String sender = "sergio73209@gmail.com";
        
        String host = "smtp.gmail.com";

       
        String port = "587";

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try
        {
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(sender));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            message.setSubject("Clave SavPro");

         //   message.setText(mensaje);
            
            message.setContent("<h3>"+mensaje+"</h3>", "text/html");

            Transport.send(message);
            System.out.println("Mail sent successfully");
            return true;
        } catch (MessagingException me)
        {
            me.printStackTrace();
            return false;
        } 
    }
    
    
    

//    public static void main(String[] args) {
//        Email email = new Email();
////        for (int i = 0; i < 10; i++) {
//                email.sendEmail("sdcortes6@misena.edu.co", "hp");         
////        }
//    }
    
    
}
