package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
@Transactional
public class PublicacionProductoTest {
    @Autowired
    private PublicacionProductoRepo publicacionProductoRepo;
    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearPublicacionProducto() throws Exception{

        LocalDateTime fechaActual = LocalDateTime.now();

        List<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<Ciudad> listaCiudad = new ArrayList<>();
        listaCiudad.add(Ciudad.ARMENIA);
        listaCiudad.add(Ciudad.BUGA);
        listaCiudad.add(Ciudad.IBAGUE);

        List<String> listaImagenes = new ArrayList<>();

        ProductoDTO productoDTO = new ProductoDTO("Terreneitor", listaCategorias, listaImagenes, listaCiudad);


        List<ComentarioDTO> comentarioDTO = new ArrayList<>();

        PublicacionProductoDTO publicacionProductoDTO = new PublicacionProductoDTO(3.5, fechaActual, 300000,
                5, "Terreneitor carro 4x4", 2, 2, productoDTO,comentarioDTO);

        int creado = publicacionProductoServicio.crearPublicacionProducto(publicacionProductoDTO,productoDTO);

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(creado);

        Assertions.assertEquals(5, publicacionProducto.getDisponibilidad());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPublicacionProducto() throws Exception {

        LocalDateTime fechaActual = LocalDateTime.now();

        List<Categoria> listaCategorias = new ArrayList<>();

        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<Ciudad> listaCiudad = new ArrayList<>();
        listaCiudad.add(Ciudad.ARMENIA);
        listaCiudad.add(Ciudad.BUGA);
        listaCiudad.add(Ciudad.IBAGUE);

        List<String> listaImagenes = new ArrayList<>();

        ProductoDTO productoDTO = new ProductoDTO("Terreneitor 2.0", listaCategorias, listaImagenes, listaCiudad);

        List<ComentarioDTO> comentarioGetDTO = new ArrayList<>();
        PublicacionProductoDTO publicacionProductoDTO = new PublicacionProductoDTO(3.5, fechaActual, 300000,
                5, "Terreneitor carro 4x4", 2, 2, productoDTO,comentarioGetDTO);

        int actualizado = publicacionProductoServicio.actualizarPublicacionProducto(1,publicacionProductoDTO,productoDTO);

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(actualizado);

        Assertions.assertEquals("Terreneitor 2.0", publicacionProducto.getProducto().getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws Exception {

        int actualizado = publicacionProductoServicio.actualizarUnidades(1,1);

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(actualizado);

        Assertions.assertEquals(1, publicacionProducto.getDisponibilidad());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPublicacion() throws Exception {

        int eliminado = publicacionProductoServicio.eliminarPublicacion(1);

        Assertions.assertNull(publicacionProductoRepo.findById(eliminado).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTodaPublicacionProducto() throws Exception {

        int eliminado = publicacionProductoServicio.eliminarTodaPublicacionProducto(1);

        Assertions.assertNull(publicacionProductoRepo.findById(eliminado).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosPublicacionUsuario() throws Exception {

        List<PublicacionProductoGetDTO> list = publicacionProductoServicio.listarProductosPublicacionUsuario(1);

        for (PublicacionProductoGetDTO p: list) {

            System.out.println(p.getDescripcion() + " Listado terminado");

        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionProductoCategoria() throws Exception {

        List<PublicacionProductoGetDTO> list = publicacionProductoServicio.listarPublicacionProductoCategoria(Categoria.HERRAMIENTAS);


        for (PublicacionProductoGetDTO p: list) {

            System.out.println(p.getDescripcion() + " Listado terminado");

        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionProductoEstado() throws Exception {

        List<PublicacionProductoGetDTO> list = publicacionProductoServicio.listarPublicacionProductosPorEstado("NO_APROBADO");

        for (PublicacionProductoGetDTO p: list) {

            System.out.println(p.getDescripcion() + " Listado terminado");

        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionProductosFavoritos() throws Exception {

        List<PublicacionProductoGetDTO> list = publicacionProductoServicio.listarPublicacionProductosFavoritos(1);
        for (PublicacionProductoGetDTO p: list) {

            System.out.println(p.getDescripcion() + " Listado terminado");

        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionProductosNombre() throws Exception {

        List<PublicacionProductoGetDTO> list = publicacionProductoServicio.listarPublicacionProductosNombre("terreneitor");

        for (PublicacionProductoGetDTO p: list) {

            System.out.println(p.getDescripcion() + " Listado terminado");

        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionProductosPrecio() throws Exception {

        List<PublicacionProductoGetDTO> list;
        list = publicacionProductoServicio.listarPublicacionProductosPrecio(120000,151000);

        for (PublicacionProductoGetDTO p: list) {
            System.out.println(p.getDescripcion()+" tiene un precio de: "+p.getPrecio() + " Listado terminado");

        }

    }

}
