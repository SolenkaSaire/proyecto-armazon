package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepo {
    void save(DetalleCompra d);
}
