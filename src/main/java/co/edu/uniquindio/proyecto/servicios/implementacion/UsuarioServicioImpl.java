package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());
        if(buscado!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }
        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();

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
    public Usuario obtenerUsuario(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    @Override
    public List<Integer> obtenerUsuariosCodigo(int codigoPublicacion ) {
        List<Integer> usuariosCodigo = usuarioRepo.obtenerUsuariosCodigo(codigoPublicacion);

        return usuariosCodigo;
    }

    private void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }
/*
    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getComentario().to,
                usuario.getMisProductos(),
                usuario.getPublicacionesFavoritas(),
                usuario.getCompra());

        return usuarioDTO;
    }
*/
    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();

                usuario.setNombre( usuarioDTO.getNombre() );
                usuario.setApellido( usuarioDTO.getApellido() );
                usuario.setEmail( usuarioDTO.getEmail() );
                usuario.setDireccion( usuarioDTO.getDireccion() );
                usuario.setTelefono( usuarioDTO.getTelefono() );
                usuario.setPassword( usuarioDTO.getPassword() );


        return usuario;
    }

}
