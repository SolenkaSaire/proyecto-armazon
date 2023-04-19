package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/publicacionproducto")
@AllArgsConstructor
public class PublicacionProductoControlador {

    private final PublicacionProductoServicio publicacionProductoServicio;


    @PostMapping("/crear")
    int crearPublicacionProducto(@RequestBody PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception{
        return publicacionProductoServicio.crearPublicacionProducto(publicacionProductoDTO,productoDTO);

    }
    @PutMapping("/actualizarPublicacionProducto/{codigo}")
    int actualizarPublicacionProducto(@RequestBody int codigoPublicacion,PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception{
        return publicacionProductoServicio.actualizarPublicacionProducto(codigoPublicacion,publicacionProductoDTO,productoDTO);

    }

    @PutMapping("/actualizarUnidades/{codigo}")
    int actualizarUnidades(@RequestBody int codigoPublicacion, int unidades) throws Exception{
    return publicacionProductoServicio.actualizarUnidades(codigoPublicacion,unidades);
    }

    @PutMapping("/actualizarEstado/{codigo}")
    int actualizarEstado(@RequestBody int codigoPublicacion, Estado estado) throws Exception{
    return publicacionProductoServicio.actualizarEstado(codigoPublicacion,estado);

    }

    @DeleteMapping("/eliminarPublicacion/{codigo}")
    int eliminarPublicacion(@RequestBody int codigoPublicacion) throws Exception{

    return publicacionProductoServicio.eliminarPublicacion(codigoPublicacion);
    }

    @DeleteMapping("/eliminarTodaPubli/{codigo}")
    int eliminarTodaPublicacionProducto(@RequestBody int codigoProducto) throws Exception{
    return publicacionProductoServicio.eliminarTodaPublicacionProducto(codigoProducto);

    }

    @GetMapping("/obtener/{codigo}")
    PublicacionProductoGetDTO obtenerPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
    return publicacionProductoServicio.obtenerPublicacionProducto(codigoPublicacion);

    }


}
