package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.modelo.Ciudad;

import java.util.List;

public interface PublicacionProductoServicio {


    int crearPublicacionProducto(ProductoDTO productoDTO) throws Exception;

    List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades);
}
