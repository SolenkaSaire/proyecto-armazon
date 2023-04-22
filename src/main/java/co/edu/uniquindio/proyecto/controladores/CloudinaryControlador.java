package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api/imagenesCloudinary")
@AllArgsConstructor
public class CloudinaryControlador {
    private final CloudinaryServicio cloudinaryServicio;

    @PostMapping("/subirImagen")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file")MultipartFile file) throws Exception{
    File imagen = cloudinaryServicio.convertir(file);
    Map respuesta= cloudinaryServicio.subirImagen(imagen,"proyectoArmazon");
    return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false,respuesta));
    }

    @DeleteMapping("/eliminarImagen/{codigo}")
   Map eliminarImagen(@RequestBody String idImagen) throws Exception{
        return cloudinaryServicio.eliminarImagen(idImagen);

    }

}
