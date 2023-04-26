package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;


    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra( @RequestBody CompraDTO compraDTO) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, "compra creada exitosamente! Código: "+ compraServicio.crearCompra(compraDTO)) );
    }





}
