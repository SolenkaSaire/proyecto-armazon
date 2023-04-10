package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraServicio {
    DetalleCompraRepo detalleCompraRepo;
    @Override
    public int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {
        DetalleCompra detalleCompra= new DetalleCompra();
        detalleCompra.getUnidades();
        detalleCompra.getPrecio();
        detalleCompra.getUnidades();
        detalleCompra.getCompra();
        detalleCompra.getCodigo();
        return 0;
    }

    @Override
    public DetalleCompraDTO obtenerProducto(int codigoCompra) {
        DetalleCompra detalleCompra= new DetalleCompra();
        detalleCompra.getPublicacionProducto().getProducto();


        return null;
    }

    @Override
    public List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) {
        List<DetalleCompra> listaCompra = detalleCompraRepo.listarDetalleComprasUsuario(codigoUsuario);
        List<DetalleCompraGetDTO> respuesta = new ArrayList<>();

        for (DetalleCompra p :listaCompra) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }


    private DetalleCompraGetDTO convertir(DetalleCompra compra) {
        DetalleCompraGetDTO compraGetDTO = new DetalleCompraGetDTO(
                compra.getCompra().getFecha_creacion(),
                compra.getCompra().getTotal(),
                compra.getCompra().getMetodoPagos(),
                compra.getCompra().getPublicacionProductos()
                );
        return compraGetDTO;
    }

}
