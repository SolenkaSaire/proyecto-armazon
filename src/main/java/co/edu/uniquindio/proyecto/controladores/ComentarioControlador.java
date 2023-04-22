package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/comentario")
@AllArgsConstructor
public class ComentarioControlador {

    private final ComentarioServicio comentarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO>crearComentario(@RequestBody ComentarioDTO comentarioDTO) throws Exception{
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK,false,"comentario creado"+ comentarioServicio.crearComentario(comentarioDTO)));
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<MensajeDTO> actualizarComentario( @PathVariable int codigoProducto,@RequestBody ComentarioDTO comentarioDTO) throws Exception{
    return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, comentarioServicio.actualizarComentario(codigoProducto, comentarioDTO)));}


    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO> eliminarComentario(@PathVariable int codigoComentario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, comentarioServicio.eliminarComentario(codigoComentario)));}



    @GetMapping("/obtener/{codigo}")
    public ResponseEntity<MensajeDTO> obtenerComentario(@PathVariable int codidoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, comentarioServicio.obtenerComentario(codidoProducto)));
    }


}
