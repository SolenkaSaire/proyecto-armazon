package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.seguridad.servicios.JwtService;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmailServicio emailServicio;
    private final JwtService jwtService;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());
        if (buscado != null) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }
        String email= "<h1>Creacion de cuenta exitosa</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'>";

        emailServicio.enviarEmail(new EmailDTO(
                "Creacion de cuenta",
                email,
                usuarioDTO.getEmail()));

        Usuario usuario = convertir(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario).getCodigo();

    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception {
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }


    @Override
    public Usuario obtenerUsuarioU(int codigoUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if (usuario.isEmpty()) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {
        return convertir(obtenerUsuarioU(codigoUsuario));
    }

    @Override
    public List<Integer> obtenerUsuariosCodigo(List<Usuario> favoritos) {
        List<Integer> usuariosCodigo = new ArrayList<>();

        for (Usuario aux : favoritos) {
            usuariosCodigo.add(aux.getCodigo());
        }

        return usuariosCodigo;
    }

    @Override
    public void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if (!existe) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

    }
    private Usuario convertir(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuario;
    }

    private UsuarioGetDTO convertir(Usuario usuario) throws Exception {
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getTelefono()
        );
        return usuarioGetDTO;
    }
    ////////////////////////////////////////////////
    @Override
    public Integer obtenerCodigoUsuarioDesdeCorreo(String correo) {

        System.out.println("El correo es: "+ correo);

        Usuario usuario = usuarioRepo.buscarUsuario(correo);
        if (usuario != null) {

            return usuario.getCodigo();
        }
        return null;
    }



}

