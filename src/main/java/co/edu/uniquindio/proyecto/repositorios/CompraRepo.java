package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Ciudad;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select p from Compra p where p.codigo = :codigoCompra")
    Optional<Compra> listarComprasPorCodigo(int codigoCompra);

    @Query("select p from Compra p where :codigoUsuario in (select c.codigo from p.usuario c)")
    List<Compra> listarMisCompras(int codigoUsuario);






        // Compra save(Compra compra);

        /////ola
      //  List<Compra> findByCodigoUsuario ( int codigoUsuario);


}