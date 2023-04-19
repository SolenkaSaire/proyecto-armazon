package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;

    @PutMapping("/aprovar/{codigo}")
    void aprobarProducto(@RequestBody PublicacionProducto publicacionProducto) throws Exception{

    }

    @PutMapping("/rechazar/{codigo}")
    void rechazarProducto(@RequestBody PublicacionProducto publicacionProducto) throws Exception{

    }

}
