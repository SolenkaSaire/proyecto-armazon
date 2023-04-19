package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class ProductoModeradorControlador {
    private final ProductoModeradorServicio productoModeradorServicio;


    public List<PublicacionProductoGetDTO> listarPublicaciones() throws Exception{

        return productoModeradorServicio.listarPublicaciones();
    }

}
