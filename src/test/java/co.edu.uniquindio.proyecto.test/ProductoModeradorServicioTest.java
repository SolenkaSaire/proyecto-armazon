package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
@SpringBootTest
@Transactional
public class ProductoModeradorServicioTest {

    @Autowired
    private ProductoModeradorRepo productoModeradorRepo;

    @Autowired
    private ProductoModeradorServicio productoModeradorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() throws Exception {

        List<PublicacionProductoGetDTO> list =  productoModeradorServicio.listarPublicaciones();

        System.out.println(list);

    }

}
