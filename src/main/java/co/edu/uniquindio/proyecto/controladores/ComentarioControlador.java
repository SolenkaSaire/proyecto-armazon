package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@AllArgsConstructor
public class ComentarioControlador {

    private final ComentarioServicio comentarioServicio;

    @PostMapping("/crear")
    int crearComentario(@RequestBody ComentarioDTO comentarioDTO) throws Exception{
        return comentarioServicio.crearComentario(comentarioDTO);
    }

    @PutMapping("/actualizar/{codigo}")
    ComentarioGetDTO actualizarComentario(@RequestBody int codigoProducto, ComentarioDTO comentarioDTO) throws Exception{
    return  comentarioServicio.actualizarComentario(codigoProducto,comentarioDTO);
    }


    @DeleteMapping("/eliminar/{codigo}")
    int eliminarComentario(@RequestBody int codigoComentario) throws Exception{
    return comentarioServicio.eliminarComentario(codigoComentario);
    }


    @GetMapping("/obtener/{codigo}")
    ComentarioGetDTO obtenerComentario(@PathVariable int codidoProducto) throws Exception{
    return comentarioServicio.obtenerComentario(codidoProducto);
    }

}
