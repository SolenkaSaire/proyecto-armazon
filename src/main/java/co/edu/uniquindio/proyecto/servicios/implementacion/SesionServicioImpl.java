package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.proyecto.seguridad.servicios.JwtService;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SesionServicioImpl implements SesionServicio {

    @Autowired
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final EmailServicio emailServicio;
    private final UsuarioRepo usuarioRepo;


    public SesionServicioImpl(JwtService jwtService, AuthenticationManager authenticationManager, UsuarioServicio usuarioServicio, UsuarioRepo usuarioRepo, PasswordEncoder passwordEncoder, EmailServicio emailServicio) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
        this.emailServicio = emailServicio;
    }


    public String solicitarCambioContrasena(String email){

        Usuario buscado = usuarioRepo.buscarUsuario(email);

        String respuesta = "El token se a enviado a su correo exitosamente.";

        if (buscado == null) {
            respuesta = "No existe un usuario con ese correo electrónico.";
        }

        // Generar un token de cambio de contraseña
        String token = jwtService.generarTokenCambioContrasena(buscado);

        // Enviar el correo electrónico de confirmación
        emailServicio.enviarCorreoConfirmacionCambioContrasena(buscado, token);

        return respuesta;

    }

    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getPassword())

        );
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        return new TokenDTO(jwtToken);
    }



    @Override
    public void logout(int codigoUsuario) {


    }
/*
    private boolean credencialesSonCorrectas(SesionDTO sesionDTO) {
        String usuario = sesionDTO.getEmail();
        String contrasenia = sesionDTO.getPassword();

        return "usuario_correcto".equals(usuario) && "contrasenia_correcta".equals(contrasenia);
    }*/

    public String cambiarContrasena(String token, String nuevaContrasena){

        String respuesta = "La contraseña se ha actualizado correctamente.";

        String email = jwtService.obtenerEmail(token);
        System.out.println("El email a buscar es: " + email);
        Usuario buscado = usuarioRepo.buscarUsuario(email);

        if (buscado == null) {
            return respuesta = "No existe un usuario con ese correo electrónico.";
        }

        if (!jwtService.validarTokenCambioContrasena(buscado, token)) {
            return respuesta = "El token de confirmación es inválido o ha expirado.";
        }
        String nuevaContrasenaCodificada = passwordEncoder.encode(nuevaContrasena);
        buscado.setPassword(nuevaContrasenaCodificada);
        System.out.println("La contraseña a guardar es: " + nuevaContrasena);
        // Guardar el usuario en la base de datos
        usuarioRepo.save(buscado);

        return respuesta;

    }

}
