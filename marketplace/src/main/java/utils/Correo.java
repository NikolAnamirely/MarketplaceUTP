/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author myers
 */
public class Correo {

    public Correo() {

    }
    public void enviarReporte(String ruta,String nombre,String destinatario) throws MessagingException{
        
        String correo = "marketplaceutp@gmail.com";
        String contra = "untcptweibzpkefj";
        String correoDestino = destinatario;
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");
        Session s = Session.getDefaultInstance(p);

        BodyPart texto = new MimeBodyPart();
        texto.setText("Este es su reporte de pedidos solicitado");
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
        System.out.println(ruta+nombre);
        adjunto.setFileName(nombre);
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);

        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correo));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
        mensaje.setSubject("Envio de Reporte solicitado");
        mensaje.setContent(m);
        Transport t = s.getTransport("smtp");
        t.connect(correo, contra);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        System.out.println("mensaje enviado");
        
    }
    public void enviarNotaPedido(String ruta,String nombre,String destinatario) throws MessagingException{
        
        String correo = "marketplaceutp@gmail.com";
        String contra = "untcptweibzpkefj";
        String correoDestino = destinatario;
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");
        Session s = Session.getDefaultInstance(p);

        BodyPart texto = new MimeBodyPart();
        texto.setText("Gracias por su preferencia. Estaremos preparando su pedido");
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
        System.out.println(ruta+nombre);
        adjunto.setFileName(nombre);
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);

        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correo));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
        mensaje.setSubject("Envio de Nota de Pedido");
        mensaje.setContent(m);
        Transport t = s.getTransport("smtp");
        t.connect(correo, contra);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        System.out.println("mensaje enviado");
        
    }

}
