package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Compra;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoModeradorRepo extends JpaRepository<PublicacionProducto,Integer> {
    @Query("select p FROM PublicacionProducto p where p.estado = ?1 ")
    List<PublicacionProducto> listarPublicacionTrue(boolean aprovadp);

    @Query("select p FROM PublicacionProducto p where p.estado = ?1 ")
    List<PublicacionProducto> listarPublicacionfalse(boolean no_Aprovado);

    @Query("select p from PublicacionProducto p where p.estado = ?1")
    List<PublicacionProducto> listarPublicacion(List<Boolean> estados);


}
