package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping
@AllArgsConstructor
public class CloudinaryControlador {
    private final CloudinaryServicio cloudinaryServicio;

    @PostMapping("/subirImagen")
    Map subirImagen(@RequestBody File file, String carpeta) throws Exception{
    return cloudinaryServicio.subirImagen(file,carpeta);
    }

    @DeleteMapping("/eliminarImagen/{codigo}")
   Map eliminarImagen(@RequestBody String idImagen) throws Exception{
        return cloudinaryServicio.eliminarImagen(idImagen);

    }

}
