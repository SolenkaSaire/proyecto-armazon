package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO, int codigoProducto, String comentario) throws Exception;

    int actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO);

    int eliminarComentario(int codigoProducto);

    ComentarioGetDTO obtenerComentario(int codidoProducto);

    List<ComentarioGetDTO> listarComentarioUsuario(int codigoUsuario);





}