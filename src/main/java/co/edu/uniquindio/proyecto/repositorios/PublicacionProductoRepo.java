package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionProductoRepo extends JpaRepository<PublicacionProducto, Integer> {

    @Query("select p from PublicacionProducto p where p.vendedor.codigo = :codigoUsuario")
    List<PublicacionProducto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from PublicacionProducto p where p.producto.categoria = :categoria")
    List<PublicacionProducto> listarProductosCategoria(Categoria categoria);

    @Query("select p from PublicacionProducto p where p.producto.nombre like concat( '%', :nombre, '%' ) and p.estado = 1")
    List<PublicacionProducto> listarProductosNombre(String nombre);

    @Query("select p from PublicacionProducto p where p.estado = :estado")
    List<PublicacionProducto> listarProductosEstado(Estado estado);


    @Query("select p.producto.nombre, p.ciudades from PublicacionProducto p where p.ciudades = :codigo")
    List<Object[]> obtenerProductos(int codigo);

    @Query("select p from PublicacionProducto p where p.producto.codigo = :codigoProducto")
    PublicacionProducto buscarProducto(int codigoProducto);

    @Query("select p from PublicacionProducto p where p.favoritos = :codigoUsuario")
    List<PublicacionProducto> listarProductosFavoritos(int codigoUsuario);

    @Query("select p from PublicacionProducto p where p.precio > :precioMinimo AND p.precio < :precioMaximo")
    List<PublicacionProducto> listarProductoPrecio(double precioMinimo, double precioMaximo);

    @Query("select  p from PublicacionProducto p where p.ciudades = :ciudad ")
    List<PublicacionProducto> listarProductoCiudad(String ciudad);

}