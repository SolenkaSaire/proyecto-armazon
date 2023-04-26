package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoModeradorDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;
    @PutMapping("/autorizacionPublicacion")
    public ResponseEntity<MensajeDTO> autorizacionPublicacion( @RequestBody ProductoModeradorDTO productoModeradorDTO) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, moderadorServicio.autorizarPublicacion(productoModeradorDTO)));
    }

}
