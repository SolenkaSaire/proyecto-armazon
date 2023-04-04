package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;

import java.util.List;
import java.util.UUID;

public class SesionServicioImpl implements SesionServicio {
    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        if (credencialesSonCorrectas(sesionDTO)) {
            String token = generarToken();
           // return new TokenDTO(token);
        } else {
            return null;
        }

        return null;
    }

    @Override
    public void logout(int codigoUsuario) {
        eliminarToken(codigoUsuario);
    }

    private boolean credencialesSonCorrectas(SesionDTO sesionDTO) {
        String usuario = sesionDTO.getEmail();
        String contrasenia = sesionDTO.getPassword();

        return "usuario_correcto".equals(usuario) && "contrasenia_correcta".equals(contrasenia);
    }

    private String generarToken() {
        return UUID.randomUUID().toString();
    }

    private void eliminarToken(int codigoUsuario) {
        /*
            if (token.getCodigoUsuario() == codigoUsuario) {
                tokensValidos.remove(token);
                break;
            }

         */
    }
}
