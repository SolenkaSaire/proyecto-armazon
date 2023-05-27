package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Ciudad;
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

        System.out.println("campo de pruebas: \nla publicacionproductoDTO es:"+publicacionProductoDTO.toString() +" y el producto es: "+publicacionProductoDTO.getProductoDTO().toString());
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


    @DeleteMapping("/eliminar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> eliminiarPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicacion Producto eliminado correctamente" +publicacionProductoServicio.eliminarPublicacion(codigoPublicacion)) );
    }


    @DeleteMapping("/eliminarAll/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarTodaPublicacionProducto(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Publicaciones asociadas al codigo del producto eliminadas correctamente, codigo: " + publicacionProductoServicio.eliminarTodaPublicacionProducto(codigoProducto)) );

    }

    @GetMapping("/obtenerByCodigo/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> obtenerPublicacionProducto(@PathVariable int codigoPublicacion) throws Exception{
     return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.obtenerPublicacionProducto(codigoPublicacion)));
    }


    @GetMapping("/listarMisPublicaciones/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarMisPublicaciones(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarProductosPublicacionUsuario(codigoUsuario)));
    }

    @GetMapping("/listarMisPublicacionesFavoritas/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarMisPublicacionesFavoritas(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductosFavoritos(codigoUsuario)));
    }

    @GetMapping("/listarPublicacionesCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarPublicacionesCategoria(@PathVariable Categoria categoria) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductoCategoria(categoria)));
    }

    @GetMapping("/listarPublicacionesCiudad/{ciudad}")
    public ResponseEntity<MensajeDTO> listarPublicacionesCiudad(@PathVariable Ciudad ciudad) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductosCiudad(ciudad)));
    }

    @GetMapping("/listarPublicacionesPrecio/{minimo}/{maximo}")
    public ResponseEntity<MensajeDTO> listarPublicacionesPrecio(@PathVariable double minimo,@PathVariable double maximo) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductosPrecio(minimo, maximo)));
    }

    @GetMapping("/listarPublicacionesNombre/{nombre}")
    public ResponseEntity<MensajeDTO> listarPublicacionesPrecio(@PathVariable String nombre) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductosNombre(nombre)));
    }

    @GetMapping("/listarPublicacionEstado/{estado}")
    public ResponseEntity<MensajeDTO> listarPublicacionEstado(@PathVariable String estado) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionProductosPorEstado(estado)));
    }


    @GetMapping("/listarPublicaciones")
    public ResponseEntity<MensajeDTO> listarTodasLasPublicaciones() throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarTodasLasPublicaciones()));
    }

}
