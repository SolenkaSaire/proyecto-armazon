package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ciudades")
@AllArgsConstructor
public class CiudadControlador {

    private final ProductoServicio productoServicio ;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listarCiudad() throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, productoServicio.listarCiudades()));
    }

}
