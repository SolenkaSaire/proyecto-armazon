package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.modelo.ProductoModerador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {

    @Query("select m from Moderador m where m.email = :correo")
    Moderador buscarModerador(String correo);

    @Query("select m.codigo, m.email from Moderador m where m.codigo =:codigo")
    Object[] obtenerDatosModerador(String codigo);

    @Query("select p from ProductoModerador p where p = :codigoModerador")
    List<ProductoModerador> listarProductoModerador (int codigoModerador);

    @Query("select p from Moderador p where p.email = :email")
    Optional<Moderador> findByEmail(String email);
}
