package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class SesionControlador {

    private final SesionServicio sesionServicio;

    TokenDTO login(SesionDTO sesionDTO){
    return sesionServicio.login(sesionDTO);
    }

    void logout(int codigoUsuario){

    }

}
