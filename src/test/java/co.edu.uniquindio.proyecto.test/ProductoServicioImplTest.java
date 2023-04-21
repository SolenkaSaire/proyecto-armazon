package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductoServicioImplTest {

    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private ProductoServicio productoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() {

        List<Categoria> listaCategorias = new ArrayList<>();

        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<String> listaImagenes = new ArrayList<>();

        listaImagenes.add("Imagen1");
        listaImagenes.add("Imagen2");
        listaImagenes.add("Imagen3");

        ProductoDTO productoDTO = new ProductoDTO("Terreneitor", listaCategorias, listaImagenes);

        int creado;
        try {
            creado = productoServicio.crearProducto(productoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Producto producto = new Producto();

        try {
            producto = productoServicio.obtenerProductoP(creado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Terreneitor", producto.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto() throws Exception {

        Producto producto = new Producto();

        try {
            producto = productoServicio.obtenerProductoP(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ProductoDTO productoDTO= new ProductoDTO("Terreneitor 2.0", producto.getCategoria(), producto.getImagenes());

        int actualizado;

        actualizado = productoServicio.actualizarProducto(1, productoDTO);

        producto = productoServicio.obtenerProductoP(actualizado);

        Assertions.assertEquals("Terreneitor 2.0", producto.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws Exception {

        int codigo = productoServicio.actualizarUnidades(1,7);

        Producto producto = productoServicio.obtenerProductoP(1);

        int actualizado = 0;

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == 1) {
                actualizado = p.getDisponibilidad();
                break;
            }
        }

        Assertions.assertEquals(7, actualizado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstado() {

        int codigo = productoServicio.actualizarEstado(1,7);

    }

    public void obtenerProducto() throws Exception {

    }

    public void obtenerProductoP() throws Exception {

    }

    public void listarProductosNombre() {



    }

}