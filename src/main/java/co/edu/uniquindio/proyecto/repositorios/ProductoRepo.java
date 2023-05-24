package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
public interface ProductoRepo extends JpaRepository<Producto, Integer > {

    @Query("select p from PublicacionProducto p where p.producto.nombre like concat('%',:nombre, '%')  and p.estado= 0 ")
    List<Producto> listarPorNombre(String nombre);


}*/




@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from PublicacionProducto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from PublicacionProducto p where p.producto.nombre like concat( '%', :nombre, '%' ) and p.estado = 1")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p from Producto p where p.categoria = :categoria")
    List<Producto> listarProductosCategoria(Categoria categoria);

    @Query("select p from PublicacionProducto p where p.estado = :estado")
    List<Producto> listarProductosEstado(Estado estado);

    //PublicacionProducto findByCodigoProducto(int codigoProducto);

    @Query("select p from PublicacionProducto p where p.favoritos = :codigoUsuario")
    List<Producto> listarProductosFavoritos(int codigoUsuario);

    @Query("select  p from PublicacionProducto p where p.precio=:codigoProducto")
    List<Producto> listarProductoPrecio(int codigoProducto);


    //@Query("select distinct c from Categoria c")
    //List<Categoria> listarCategorias1();

    /*@Query("select c from co.edu.uniquindio.proyecto.modelo.Categoria c")
    List<Categoria> listarCategorias();*/
}
