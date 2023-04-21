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

/*
    @PostMapping("/crear")
    int crearPublicacionProducto(@RequestBody PublicacionProductoDTO publicacionProductoDTO,@RequestBody ProductoDTO productoDTO) throws Exception{
        return publicacionProductoServicio.crearPublicacionProducto(publicacionProductoDTO,productoDTO);

    }*/
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearPublicacionProducto(@RequestBody PublicacionProductoRequestDTO request)  throws Exception{
        int newCodigo=0;
        newCodigo = publicacionProductoServicio.crearPublicacionProducto(request.getPublicacionProductoDTO(), request.getProductoDTO());
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion producto creado exitosamente! Código: "+newCodigo) );
    }
/*
    @PutMapping("/actualizarPublicacionProducto/{codigo}")
    int actualizarPublicacionProducto(@PathVariable int codigoPublicacion,@RequestBody PublicacionProductoDTO publicacionProductoDTO,@RequestBody ProductoDTO productoDTO) throws Exception{
        return publicacionProductoServicio.actualizarPublicacionProducto(codigoPublicacion,publicacionProductoDTO,productoDTO);

    }*/
    @PutMapping("/actualizar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> actualizarPublicacionProducto(@PathVariable int codigoPublicacion,@RequestBody PublicacionProductoRequestDTO request)  throws Exception{
        int newCodigo=0;
        newCodigo =   publicacionProductoServicio.actualizarPublicacionProducto( codigoPublicacion, request.getPublicacionProductoDTO() , request.getProductoDTO());
       // return publicacionProductoServicio.actualizarPublicacionProducto(codigoPublicacion,publicacionProductoDTO,productoDTO);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion producto actualizada exitosamente! Código: "+newCodigo) );

    }

    @PutMapping("/actualizarUnidades/{codigo}")
    int actualizarUnidades(@PathVariable int codigoPublicacion,@PathVariable int unidades) throws Exception{
    return publicacionProductoServicio.actualizarUnidades(codigoPublicacion,unidades);
    }

    @PutMapping("/actualizarEstado/{codigo}")
    int actualizarEstado(@PathVariable int codigoPublicacion,@RequestBody Estado estado) throws Exception{
    return publicacionProductoServicio.actualizarEstado(codigoPublicacion,estado);

    }

    @DeleteMapping("/eliminar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> eliminiarPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
        int deletedCodigo=0;
        deletedCodigo= publicacionProductoServicio.eliminarPublicacion(codigoPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion Producto eliminado correctamente") );
    }


    @DeleteMapping("/eliminarAll/{codigo}")
    int eliminarTodaPublicacionProducto(@PathVariable int codigoProducto) throws Exception{
    return publicacionProductoServicio.eliminarTodaPublicacionProducto(codigoProducto);

    }

    @GetMapping("/obtener/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> obtenerPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
     return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.obtenerPublicacionProducto(codigoPublicacion)));
    }


}
