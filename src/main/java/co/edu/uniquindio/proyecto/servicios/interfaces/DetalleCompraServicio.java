package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {


    DetalleCompraDTO obtenerProducto(int codigoCompra);

    List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario);


    List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras);

    DetalleCompra obtenerDetalleCompra(int codigoDetalleCompra) throws Exception;
}
