package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.ProductoModerador;
import co.edu.uniquindio.proyecto.modelo.Usuario;

import java.util.List;

public interface UsuarioServicio {
//funciones asociadas a la entidad, crear, actualizar, iniciar sesion, etc

    int crearUsuario(UsuarioDTO usuarioDTO) throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminiarUsuario(int codigoUsuario) throws Exception;

    //UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;
    
    Usuario obtenerUsuario(int codigo) throws Exception;

    List<Integer> obtenerUsuariosCodigo( List<Usuario> favoritos) throws Exception;
}