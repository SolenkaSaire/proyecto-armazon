package co.edu.uniquindio.proyecto.test;

import ch.qos.logback.core.CoreConstants;
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

        List<DetalleCompraDTO> respuesta = new ArrayList<>();
        respuesta.add(new DetalleCompraDTO(1, 1));
        respuesta.add(new DetalleCompraDTO(1, 2));

        CompraDTO compraDTO = new CompraDTO(MetodoPago.NEQUI, 1, respuesta);

        int codigo = compraServicio.crearCompra(compraDTO);

        System.out.println("Esta es el codigo: "+codigo);

        //System.out.println("Esta es el precio de la compra: "+compraDTO.getTotal());

        CompraGetDTO compra = compraServicio.obtenerCompra(codigo);

        System.out.println("Esta es el precio: "+compra.getTotal());

        Assertions.assertEquals(250000, compra.getTotal());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar() throws Exception {

        List<CompraGetDTO> listaCompra = compraServicio.listarMisCompras(1);

        System.out.println(listaCompra);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() throws Exception {

        CompraGetDTO compra = compraServicio.obtenerCompra(1);

        Assertions.assertNotNull(compra);

    }
}
