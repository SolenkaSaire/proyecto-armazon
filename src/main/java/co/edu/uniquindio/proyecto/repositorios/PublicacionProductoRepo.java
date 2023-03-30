package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import co.edu.uniquindio.proyecto.jakarta.persistence.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionProductoRepo extends JpaRepository<PublicacionProducto, Integer> {

    @Query("select p from PublicacionProducto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from PublicacionProducto p where p.producto.nombre like concat( '%', :nombre, '%' ) and p.estado = 1")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p.producto.nombre, p.ciudades from PublicacionProducto p where p.ciudades = :codigo")
    List<Object[]> obtenerProductos(int codigo);

}