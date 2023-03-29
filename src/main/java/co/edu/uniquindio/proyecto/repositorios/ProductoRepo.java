package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepo extends JpaRepository<Producto, Integer > {

    @Query("select p from PublicacionProducto p where p.producto.nombre like concat('%',:nombre, '%')  and p.estado= 0 ")
    List<Producto> listarPorNombre(String nombre);


}
