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
            helper.setFrom("cristianr.gonzalezi@uqvirtual.edu.co");//"no_reply@dominio.com");
            javaMailSender.send(mensaje);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enviarCorreoConfirmacionCambioContrasena(Usuario usuario, String token) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("cristianr.gonzalezi@uqvirtual.edu.co");
        mensaje.setTo(usuario.getEmail());
        mensaje.setSubject("Confirmación de cambio de contraseña");
        mensaje.setText("Para confirmar el cambio de contraseña, por favor haga clic en el siguiente enlace:\n\n" + "http://localhost:8081/api/auth/confirmarCambio?token=" + token + "&contrasena=" + "TuNuevaContraseña");

        javaMailSender.send(mensaje);
    }

}