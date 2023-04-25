package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Map;
@RestController
@RequestMapping("api/imagenes")
@AllArgsConstructor
public class ImagenesControlador {
    private final CloudinaryServicio cloudinaryServicio;
    @PostMapping("/upload/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file") MultipartFile file,@PathVariable int codigoPublicacion) throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = cloudinaryServicio.subirImagen(imagen, "co/edu/uniquindio/proyecto", codigoPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, respuesta ) );
    }
    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO> eliminarImagen(@PathVariable String id) throws Exception{
        id= "imagenes/Captura_de_pantalla_4_.png11414006616483813673";
        Map respuesta = cloudinaryServicio.eliminarImagen(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, respuesta ) );
    }
}