package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/favorito")
@AllArgsConstructor
public class FavoritoControlador {

    private final FavoritoServicio favoritoServicio;

    @PostMapping("/agregar")
    public ResponseEntity<MensajeDTO> agregarPublicacionFavorita(@RequestBody ComentarioDTO comentarioDTO){
        System.out.println("favorito agregado del usuario con codigo: " +comentarioDTO.getCodigoUsuario());
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK,false,"favorito agregado del usuario con codigo: "+ favoritoServicio.agregarPublicacionFavorita(comentarioDTO.getCodigoUsuario(),comentarioDTO.getCodigoPublicacionProducto())));
    }



    @PostMapping("/eliminar/{idUsuario}/{idPublicacion}")
    public ResponseEntity<MensajeDTO> eliminarPublicacionFavorita(@PathVariable int idUsuario,@PathVariable int idPublicacion){
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK,false,"favorito eliminado del usuario con codigo: "+ favoritoServicio.eliminarPublicacionFavorita(idUsuario,idPublicacion)));
    }

}


