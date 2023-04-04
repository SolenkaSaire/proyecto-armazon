package co.edu.uniquindio.proyecto.servicios.implementacion;


import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Comentario;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

   private final ComentarioRepo comentarioRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO, int codigoProducto, String comentario) throws Exception {
        PublicacionProducto publicacionProducto = new PublicacionProducto();
        Comentario comentarios= new Comentario(comentario);
        for (Comentario p : publicacionProducto.getComentarios()) {
            if (publicacionProducto.getCodigo() == codigoProducto) {
                p.getPublicacionProducto().getComentarios().add(comentarios );
                break;
            }
        }

        return 0;
    }

    @Override
    public int actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) {
        return 0;
    }

    @Override
    public int eliminarComentario(int codigoProducto) {
        return 0;
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codidoProducto) {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> listarComentarioUsuario(int codigoUsuario) {
        return null;
    }
}
