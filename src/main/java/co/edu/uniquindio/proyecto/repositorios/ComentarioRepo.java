package co.edu.uniquindio.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {

    @Query("select p.estrellas, p.texto, p.usuario.nombre from Comentario p where p.codigo = :codigo")
    List<Object[]> obtenerComentarios(int codigo);

    @Query("select p from Comentario p where p.usuario.codigo = :codigoUsuario")
    List<Comentario> listarComentarioUsuario(int codigoUsuario);

    @Query("select p from Comentario p where p.publicacionProducto.codigo = :codigoPublicacion")
    List<Comentario> listarComentariosPublicacion(int codigoPublicacion);
}
