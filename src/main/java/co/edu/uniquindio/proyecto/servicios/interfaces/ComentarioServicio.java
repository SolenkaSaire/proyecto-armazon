package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO, int codigoProducto, String comentario) throws Exception;

    ComentarioGetDTO actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) throws Exception;

    int eliminarComentario(int codigoComentario) throws Exception;

    ComentarioGetDTO obtenerComentario(int codidoProducto) throws Exception;

    List<ComentarioGetDTO> listarComentarioUsuario(int codigoUsuario);
    List<String>  obtenerListaComentarios(List<Comentario> comentarios);
}