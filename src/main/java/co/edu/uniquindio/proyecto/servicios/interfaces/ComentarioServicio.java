package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;


import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    ComentarioGetDTO actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) throws Exception;

    int eliminarComentario(int codigoComentario) throws Exception;

    ComentarioGetDTO obtenerComentario(int codidoProducto) throws Exception;

    List<ComentarioGetDTO> listarComentarioUsuario(int codigoUsuario);

    List<ComentarioGetDTO> listarComentarios(int codigoPublicacion);
}