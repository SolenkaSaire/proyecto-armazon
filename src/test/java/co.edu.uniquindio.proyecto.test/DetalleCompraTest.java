package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.Producto;
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
    public void listarProductosUsuario(){

        List<DetalleCompraGetDTO> list = detalleCompraServicio.listarProductosUsuario(1);

        System.out.println(list);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosUsuarioRepetido(){

        List<DetalleCompraGetDTO> list = detalleCompraServicio.listarProductosUsuario(1);

        System.out.println(list);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() throws Exception {

        DetalleCompraGetDTO detalleCompra = detalleCompraServicio.obtenerDetalleCompra(1);

        Assertions.assertNotNull(detalleCompra);

    }

}
