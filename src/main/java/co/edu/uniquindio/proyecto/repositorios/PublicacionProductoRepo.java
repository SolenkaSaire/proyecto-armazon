package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Ciudad;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionProductoRepo extends JpaRepository<PublicacionProducto, Integer> {

    @Query("select p from PublicacionProducto p where p.vendedor.codigo = :codigoUsuario")
    List<PublicacionProducto> listarProductosUsuario(int codigoUsuario);


/*
*   @Query("select p from PublicacionProducto p where p.producto.categoria = :categoria")
    List<PublicacionProducto> listarProductosCategoria(Categoria categoria);
*
* */

    @Query("select p from PublicacionProducto p where :categoria member of p.producto.categoria")
    List<PublicacionProducto> listarProductosCategoria(Categoria categoria);

    /*@Query("select p from PublicacionProducto p where p.producto.nombre like concat( '%', :nombre, '%' ) and p.estado = 1")
    List<PublicacionProducto> listarProductosNombre(String nombre);*/
    @Query("select p from PublicacionProducto p where p.producto.nombre = :nombre and p.estado = 1")
    List<PublicacionProducto> listarProductosNombre(String nombre);


    @Query("select p from PublicacionProducto p where p.estado = :estado")
    List<PublicacionProducto> listarProductosEstado(Estado estado);

    @Query("select p from PublicacionProducto p where p.producto.codigo = :codigoProducto")
    PublicacionProducto buscarProducto(int codigoProducto);
    @Query("select p from PublicacionProducto p join p.favoritos f where f.codigo = :codigoUsuario")
    List<PublicacionProducto> listarProductosFavoritos(int codigoUsuario);
    @Query("select p from PublicacionProducto p where p.precio > :precioMinimo and p.precio < :precioMaximo")
    List<PublicacionProducto> listarProductoPrecio(double precioMinimo, double precioMaximo);
    /*
    @Query("select  p from PublicacionProducto p where p.ciudades = :ciudad ")
    List<PublicacionProducto> listarProductoCiudad(String ciudad);*/

    @Query("select p from PublicacionProducto p where :ciudad member of p.producto.ciudad")
    List<PublicacionProducto> listarProductosCiudad(Ciudad ciudad);


}