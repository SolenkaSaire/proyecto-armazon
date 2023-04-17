package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
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
    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());
        if(buscado!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }
        Usuario usuario = convertir(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
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
    public List<Integer> obtenerUsuariosCodigo(List<Usuario> favoritos ) {
        List<Integer> usuariosCodigo = new ArrayList<>();

        for (Usuario aux :favoritos ) {
            usuariosCodigo.add(aux.getCodigo());
        }

        return usuariosCodigo;
    }

    @Override
    public void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    public List<Integer> obtenerCodCompras(Usuario usuario){
        List<Integer> compras= new ArrayList<>();
        for (Compra miCompra: usuario.getCompra() ) {
            compras.add(miCompra.getCodigo());
        }
        return compras;
    }


    public List<Integer> obtenerCodPublicacionesFavoritas(Usuario usuario){
        List<Integer> publicacionesFavoritas= new ArrayList<>();
        for (PublicacionProducto misFavoritos: usuario.getPublicacionesFavoritas() ) {
            publicacionesFavoritas.add(misFavoritos.getCodigo());
        }
        return publicacionesFavoritas;
    }

    public List<Integer> obtenerCodPublicaciones(Usuario usuario){
        List<Integer> publicaciones= new ArrayList<>();
        for (PublicacionProducto misPublicaciones: usuario.getMisProductos() ) {
            publicaciones.add(misPublicaciones.getCodigo());
        }
        return publicaciones;
    }

    public List<String> obtenerComentariosUsuario(Usuario usuario){
        List<String> comentarios= new ArrayList<>();
        for (Comentario comentario: usuario.getComentario() ) {
            comentarios.add(comentario.getTexto());
        }
        return comentarios;
    }

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
