package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Producto;
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

        System.out.println(creado);

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
    public void actualizarProducto() {

        ProductoDTO productoDTO= new ProductoDTO()

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() {


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstado() {



    }

    public void obtenerProducto() throws Exception {

    }

    public void obtenerProductoP() throws Exception {

    }

    public void listarProductosNombre() {



    }

}