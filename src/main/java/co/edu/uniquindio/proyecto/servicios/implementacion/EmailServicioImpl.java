package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
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
            helper.setText(emailDTO.getCuerpo());
            helper.setTo(emailDTO.getDestinatario());
            helper.setFrom("cristia9725291@gmail.com");//"no_reply@dominio.com");
            javaMailSender.send(mensaje);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}