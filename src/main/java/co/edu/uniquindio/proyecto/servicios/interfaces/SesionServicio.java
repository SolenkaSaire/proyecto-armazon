package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);

    TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception;

    String crearModerador();

    void logout(int codigoUsuario);

    String solicitarCambioContrasena(String email);

    String cambiarContrasena(String token, String nuevaContrasena);

}