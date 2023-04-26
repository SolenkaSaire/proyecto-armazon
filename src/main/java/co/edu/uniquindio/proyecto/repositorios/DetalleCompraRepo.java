package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Integer> {
    @Query("select p from DetalleCompra p where p.compra.usuario.codigo = :codigoUsuario")
    List<DetalleCompra> listarDetalleComprasUsuario(int codigoUsuario);

}
