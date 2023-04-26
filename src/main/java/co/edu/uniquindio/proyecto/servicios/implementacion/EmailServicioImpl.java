package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {
    private final JavaMailSender javaMailSender;
    @Override
    public void enviarEmail(EmailDTO emailDTO) {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        try{
            helper.setSubject(emailDTO.getAsunto());
            helper.setText(emailDTO.getCuerpo(), true);
            helper.setTo(emailDTO.getDestinatario());
            helper.setFrom("cristianr.gonzalezi@uqvirtual.edu.co");
            javaMailSender.send(mensaje);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enviarCorreoConfirmacionCambioContrasena(Usuario usuario, String token) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("cristianr.gonzalezi@uqvirtual.edu.co");
        mensaje.setTo(usuario.getEmail());
        String titulo= "<h1>Confirmacion de cambio de contraseña</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://res.cloudinary.com/dwkkkwnpr/image/upload/v1682391603/co/edu/uniquindio/proyecto/Imagen_de_WhatsApp_2023-04-21_a_las_11.31.00.jpg' width='300' height='200'>";
        String cuerpo= "<h1>Para confirmar el cambio de contraseña, por favor haga clic en el siguiente enlace:</h1><h2><p>En tu cuenta de Armazon</p></h2><h3>http://localhost:8081/api/auth/confirmarCambio?token=</h3>" +  token +"<h1>&contrasena=TuNuevaContrasenia<h1>";
        mensaje.setSubject(titulo);
        mensaje.setText(cuerpo);

        javaMailSender.send(mensaje);
    }

}