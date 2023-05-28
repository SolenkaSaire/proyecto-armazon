package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthControlador {
    private final UsuarioServicio usuarioServicio;
    private final SesionServicio sesionServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login( @RequestBody SesionDTO loginUser) {
        TokenDTO jwtTokenDto = sesionServicio.login(loginUser);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, jwtTokenDto)  );
        //sesionServicio.login(loginUser))
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarUsuario( @RequestBody UsuarioDTO cliente) throws Exception {
        usuarioServicio.crearUsuario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Cliente creado correctamente"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<MensajeDTO> refreshToken(@RequestBody TokenDTO tokenDTO) throws Exception {
        sesionServicio.refreshToken(tokenDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Token refresh correctamente"));
    }

    @PostMapping("/solicitar")
    public ResponseEntity<MensajeDTO> solicitarCambioContrasena(@RequestParam String email) {

        String mensaje = sesionServicio.solicitarCambioContrasena(email);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "restablecer password correctamente"));

    }

    @PostMapping("/confirmarCambio")
    public ResponseEntity<MensajeDTO> cambiarContrasena(@RequestParam("token") String token, @RequestParam("contrasena") String nuevaContrasena) {

        String mensaje = sesionServicio.cambiarContrasena(token, nuevaContrasena);
        // Validar el token de cambio de contraseña

        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "restablecer password correctamente"));

    }

    @PostMapping("/generar")
    public ResponseEntity<?> inicializarModeradores() {
        String mensaje = sesionServicio.crearModerador();
        return ResponseEntity.ok(mensaje);
    }

}