package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Compra;
import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Integer> {
    //void save(DetalleCompra d);

    @Query("select p from DetalleCompra p where p.compra.publicacionProductos = :codigoCompra")
    List<Compra> listarDetalleCompras(int codigoCompra);

    @Query("select p from DetalleCompra p where p.compra.usuario.codigo = :codigoUsuario")
    List<DetalleCompra> listarDetalleComprasUsuario(int codigoUsuario);
}
