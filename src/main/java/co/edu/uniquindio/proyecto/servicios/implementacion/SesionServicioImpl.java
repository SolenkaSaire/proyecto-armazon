package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.proyecto.seguridad.servicios.JwtService;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SesionServicioImpl implements SesionServicio {

    @Autowired
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public SesionServicioImpl(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
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



}
