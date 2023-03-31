package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Categoria;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;

import java.util.List;

public interface DetalleCompraServicio {

    int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception;


    DetalleCompraDTO obtenerProducto(int codigoCompra);

    List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario);


}
