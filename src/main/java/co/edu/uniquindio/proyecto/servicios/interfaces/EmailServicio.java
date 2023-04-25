package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;

public interface EmailServicio {

    void enviarEmail(EmailDTO emailDTO);

    void enviarCorreoConfirmacionCambioContrasena(Usuario usuario, String token);

}