package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;

    @PutMapping("/aprovar/{codigo}")
    void aprobarProducto(PublicacionProducto publicacionProducto) throws Exception{

    }

    @PutMapping("/rechazar/{codigo}")
    void rechazarProducto(PublicacionProducto publicacionProducto) throws Exception{

    }

}
