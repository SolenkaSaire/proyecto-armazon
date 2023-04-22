package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/publicacionproducto")
@AllArgsConstructor
public class PublicacionProductoControlador {

    private final PublicacionProductoServicio publicacionProductoServicio;


    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearPublicacionProducto(@RequestBody PublicacionProductoDTO publicacionProductoDTO) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion producto creado exitosamente! Código: "+ publicacionProductoServicio.crearPublicacionProducto(publicacionProductoDTO, publicacionProductoDTO.getProductoDTO()) ));

    }
    @PutMapping("/actualizar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> actualizarPublicacionProducto(@PathVariable int codigoPublicacion,@RequestBody PublicacionProductoDTO publicacionProductoDTO)  throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion producto actualizada exitosamente! Código: "+publicacionProductoServicio.actualizarPublicacionProducto( codigoPublicacion, publicacionProductoDTO , publicacionProductoDTO.getProductoDTO())) );
    }

    @PutMapping("/actualizarUnidades/{codigoPublicacion}/{unidades}")
    public ResponseEntity<MensajeDTO> actualizarUnidadesPublicacion(@PathVariable int codigoPublicacion,@PathVariable int unidades)  throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Unidades de la Publicacion actualizada exitosamente! Código: "+publicacionProductoServicio.actualizarUnidades(codigoPublicacion,unidades)) );
    }

    @PutMapping("/actualizarEstado/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> actualizarEstadoPublicacion(@PathVariable int codigoPublicacion,@RequestBody Estado estado)  throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Estado Publicacion actualizada exitosamente! Código: "+publicacionProductoServicio.actualizarEstado(codigoPublicacion,estado)) );
    }

    @DeleteMapping("/eliminar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> eliminiarPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
        int deletedCodigo=0;
        deletedCodigo= publicacionProductoServicio.eliminarPublicacion(codigoPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion Producto eliminado correctamente") );
    }


    @DeleteMapping("/eliminarAll/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarTodaPublicacionProducto(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicaciones asociadas al codigo del producto eliminadas correctamente, codigo: " + publicacionProductoServicio.eliminarTodaPublicacionProducto(codigoProducto)) );

    }

    @GetMapping("/obtener/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> obtenerPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
     return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.obtenerPublicacionProducto(codigoPublicacion)));
    }


}
