package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.ProductoModerador;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoModeradorRepo extends JpaRepository<ProductoModerador,Integer> {


}
