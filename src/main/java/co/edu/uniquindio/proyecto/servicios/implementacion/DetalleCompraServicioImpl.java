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
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleCompraServicioImpl implements DetalleCompraServicio {
    DetalleCompraRepo detalleCompraRepo;

    @Override
    public List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) {
        List<DetalleCompra> listaCompra = detalleCompraRepo.listarDetalleComprasUsuario(codigoUsuario);
        List<DetalleCompraGetDTO> respuesta = new ArrayList<>();

        for (DetalleCompra p :listaCompra) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras) {
        List<Integer> codigoDetalles = new ArrayList<>();
        for (DetalleCompra d: compras) {
            codigoDetalles.add( d.getCodigo() );

        }
        return codigoDetalles;
    }

    @Override
    public DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(codigoDetalleCompra);

        if(detalleCompra.isEmpty() ){
            throw new Exception("El código "+codigoDetalleCompra+" no está asociado a ningún producto");
        }

        return convertir(detalleCompra.get());
    }

    private DetalleCompraGetDTO convertir(DetalleCompra detalleCompra) {
        DetalleCompraGetDTO detalleCompraGetDTO = new DetalleCompraGetDTO(
                detalleCompra.getUnidades(),
                detalleCompra.getPrecio(),
                detalleCompra.getPublicacionProducto().getCodigo(),
                detalleCompra.getCompra().getCodigo(),
                detalleCompra.getCompra().getTotal(),
                detalleCompra.getCompra().getMetodoPagos(),
                detalleCompra.getCompra().getFecha_creacion(),
                detalleCompra.getCompra().getUsuario().getCodigo(),
                detalleCompra.getCompra().getUsuario().getNombre()
        );
        return detalleCompraGetDTO;
    }

    public DetalleCompraDTO convertirDTO(DetalleCompra detalleCompra) {
        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                detalleCompra.getUnidades(),
                detalleCompra.getPublicacionProducto().getCodigo()
        );
        return detalleCompraDTO;
    }


}
