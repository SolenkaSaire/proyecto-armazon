package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoModeradorDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import org.junit.jupiter.api.Assertions;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.time.LocalDateTime;
import java.util.*;

import java.util.List;

@SpringBootTest
@Transactional
public class ModeradorTest {

    @Autowired
    private ModeradorRepo moderadorRepo;
    @Autowired
    private ModeradorServicio moderadorServicio;

    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Autowired
    private ProductoModeradorRepo productoModeradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void autorizarPublicacion() throws Exception {

        ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO("Me gusta el Terreneitor, lo apruebo", 2,Estado.APROBADO,1);

        PublicacionProducto p = publicacionProductoServicio.obtenerPublicacionProductoP(productoModeradorDTO.getCodigoPublicacion());
        System.out.println("el estado antiguo de la publi es: "+ p.getEstado().toString());
        moderadorServicio.autorizarPublicacion(productoModeradorDTO);

        Estado estado = Estado.APROBADO;

        Assertions.assertEquals(estado.toString(), p.getEstado().toString());

    }
/*
    @Test
    @Sql("classpath:dataset.sql")
    public void aprobarProducto() throws Exception {

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(1);

        ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO("Me gusta el Terreneitor", 2);

        moderadorServicio.aprobarProducto(publicacionProducto, productoModeradorDTO);

        Estado estado = Estado.APROBADO;

        Assertions.assertEquals(estado.toString(), publicacionProducto.getEstado().toString());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void rechazarProducto() throws Exception {

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(1);

        ProductoModeradorDTO productoModeradorDTO = new ProductoModeradorDTO("No me gusto el color", 2);

        moderadorServicio.rechazarProducto(publicacionProducto, productoModeradorDTO);

        Estado estado = Estado.NO_APROBADO;

        Assertions.assertEquals(estado.toString(), publicacionProducto.getEstado().toString());

    }*/

}
