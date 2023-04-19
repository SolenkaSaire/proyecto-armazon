package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class EmailControlador {
    private final EmailServicio emailServicio;

    @PutMapping("/enviar")
    void enviarEmail(EmailDTO emailDTO){

    }
}
