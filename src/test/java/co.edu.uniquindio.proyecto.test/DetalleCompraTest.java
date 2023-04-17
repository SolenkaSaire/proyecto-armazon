package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class DetalleCompraTest {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;
    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto(){

        DetalleCompraDTO detalleCompraDTO = detalleCompraServicio.obtenerProducto(1);

        Assertions.assertNotNull(detalleCompraDTO);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosUsuario(){

        List<DetalleCompraGetDTO> list = detalleCompraServicio.listarProductosUsuario(1);

        System.out.println(list);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetallesCodigo(){

        List<DetalleCompra> listaCompra = detalleCompraRepo.listarDetalleComprasUsuario(1);

        List<Integer> list = detalleCompraServicio.obtenerDetallesCodigo(listaCompra);

        System.out.println(list);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetalleCompra() throws Exception {

        DetalleCompra detalleCompra = detalleCompraServicio.obtenerDetalleCompra(1);

        Assertions.assertNotNull(detalleCompra);

    }

}
