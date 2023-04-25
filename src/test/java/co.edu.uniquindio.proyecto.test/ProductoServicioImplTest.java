package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Ciudad;
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
    public void crearProducto() throws Exception{

        List<Categoria> listaCategorias = new ArrayList<>();

        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<String> listaImagenes = new ArrayList<>();

        listaImagenes.add("Imagen1");
        listaImagenes.add("Imagen2");
        listaImagenes.add("Imagen3");

        List<Ciudad> listaCiudad = new ArrayList<>();
        listaCiudad.add(Ciudad.ARMENIA);
        listaCiudad.add(Ciudad.BUGA);
        listaCiudad.add(Ciudad.IBAGUE);

        ProductoDTO productoDTO = new ProductoDTO("Terreneitor", listaCategorias, listaImagenes, listaCiudad);

        int creado;

        creado = productoServicio.crearProducto(productoDTO);

        Producto producto = new Producto();

        producto = productoServicio.obtenerProductoP(creado);

        Assertions.assertEquals("Terreneitor", producto.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto() throws Exception{

        List<Categoria> listaCategorias = new ArrayList<>();

        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<String> listaImagenes = new ArrayList<>();

        listaImagenes.add("Imagen1");
        listaImagenes.add("Imagen2");
        listaImagenes.add("Imagen3");

        List<Ciudad> listaCiudad = new ArrayList<>();
        listaCiudad.add(Ciudad.ARMENIA);
        listaCiudad.add(Ciudad.BUGA);
        listaCiudad.add(Ciudad.IBAGUE);

        ProductoDTO productoDTO= new ProductoDTO("Terreneitor 2.0", listaCategorias, listaImagenes, listaCiudad);

        int actualizado;

        actualizado = productoServicio.actualizarProducto(1, productoDTO);

        Producto producto = new Producto();

        producto = productoServicio.obtenerProductoP(actualizado);

        Assertions.assertEquals("Terreneitor 2.0", producto.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws Exception{

        int actualizado = productoServicio.actualizarUnidades(1, 7);

        Producto producto = productoServicio.obtenerProductoP(actualizado);

        int actualizadoProducto = 0;

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == actualizado) {
                actualizadoProducto = p.getDisponibilidad();
                break;
            }
        }

        Assertions.assertEquals(7, actualizadoProducto);

    }

}