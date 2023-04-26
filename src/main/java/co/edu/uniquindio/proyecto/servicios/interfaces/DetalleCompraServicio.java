package co.edu.uniquindio.proyecto.servicios.interfaces;


import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;


import java.util.List;

public interface DetalleCompraServicio {


    DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception;


    List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario);


    List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras);

}
