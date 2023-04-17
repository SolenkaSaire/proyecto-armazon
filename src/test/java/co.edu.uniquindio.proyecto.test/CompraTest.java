package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.implementacion.DetalleCompraServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class CompraTest {

    @Autowired
    private UsuarioRepo compraRepo;
    @Autowired
    private CompraServicio compraServicio;
    @Autowired
    private DetalleCompraRepo detalleCompraRepo;
    @Autowired
    private DetalleCompraServicioImpl detalleCompraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crear() throws Exception {

        List<DetalleCompra> listaCompra = detalleCompraRepo.listarDetalleComprasUsuario(1);
        List<DetalleCompraDTO> respuesta = new ArrayList<>();

        for (DetalleCompra p :listaCompra) {
            respuesta.add(detalleCompraServicio.convertirDTO(p));
        }

        CompraDTO compraDTO = new CompraDTO(12.212, MetodoPago.NEQUI, 1, respuesta);

        int codigo = compraServicio.crearCompra(compraDTO);

        Compra compra = compraServicio.obtener(codigo);

        Assertions.assertEquals(12.212, compra.getTotal());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar() throws Exception {

        List<CompraGetDTO> listaCompra = compraServicio.listarCompras(1);

        System.out.println(listaCompra);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() throws Exception {

        Compra compra = compraServicio.obtener(1);

        Assertions.assertNotNull(compra);

    }
}
