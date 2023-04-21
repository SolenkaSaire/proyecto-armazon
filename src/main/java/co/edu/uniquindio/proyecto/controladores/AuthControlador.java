package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth1")
@AllArgsConstructor
public class AuthControlador {
    private final UsuarioServicio clienteServicio;
    private final SesionServicio sesionServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO cliente) throws Exception {
        clienteServicio.crearUsuario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Cliente creado correctamente"));
    }
}