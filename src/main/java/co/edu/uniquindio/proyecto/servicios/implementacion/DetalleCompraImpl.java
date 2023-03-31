package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraServicio {
    @Override
    public int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {
        return 0;
    }

    @Override
    public DetalleCompraDTO obtenerProducto(int codigoCompra) {
        return null;
    }

    @Override
    public List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }
/*
    private  final DetalleCompraRepo detalleCompraRepo;

    @Override
    public int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setPrecio(detalleCompraDTO.getPrecio());
        detalleCompra.setCodigo(detalleCompraDTO.getCodigoProducto());
        detalleCompra.setUnidades(detalleCompraDTO.getUnidades());


        return 0;
    }

    @Override
    public DetalleCompraDTO obtenerProducto(int codigoCompra) {
        return null;
    }

    @Override
    public List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }
    */

}
