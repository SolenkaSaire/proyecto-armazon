package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class PublicacionProductoTest {

    @Autowired
    private PublicacionProductoRepo publicacionProductoRepo;
    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPublicacionProducto(){

        LocalDateTime fechaActual = LocalDateTime.now();

        PublicacionProductoDTO publicacionProductoDTO = new PublicacionProductoDTO(3.5, fechaActual, 300000,
                5, "Terreneitor carro 4x4", 2, 2);

        List<Categoria> listaCategorias = new ArrayList<>();

        listaCategorias.add(Categoria.HERRAMIENTAS);
        listaCategorias.add(Categoria.HOGAR);
        listaCategorias.add(Categoria.COCHES);

        List<String> listaImagenes = new ArrayList<>();

        ProductoDTO productoDTO = new ProductoDTO("Terreneitor", listaCategorias, listaImagenes);



    }

    public void actualizarPublicacionProducto(int codigoPublicacion, PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception {



    }

    public void actualizarUnidades(int codigoPublicacion, int unidades) throws Exception {

    }

    public void actualizarEstado(int codigoPublicacion, Estado estado) throws Exception {

    }

    public void eliminarPublicacion(int codigoPublicacion) throws Exception {

    }

    public void eliminarTodaPublicacionProducto(int codigoProducto) throws Exception {

    }

    public void obtenerPublicacionProducto(int codigoPublicacion) throws Exception {

    }

    public void listarProductosPublicacionUsuario(int codigoUsuario) throws Exception {

    }

    public void listarPublicacionProductoCategoria(Categoria categoria) throws Exception {

    }

    public void listarPublicacionProductosFavoritos(int codigoUsuario) throws Exception {

    }

    public void listarPublicacionProductosNombre(String nombre) throws Exception {

    }

    public void listarPublicacionProductosPrecio(float precioMinimo, float precioMaximo) throws Exception {

    }

}
