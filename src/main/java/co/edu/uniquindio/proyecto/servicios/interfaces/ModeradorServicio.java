package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.ProductoModerador;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;

import java.util.List;

public interface ModeradorServicio {



    void aprobarProducto(PublicacionProducto publicacionProducto, ProductoModerador productoModerador) throws Exception;

    void rechazarProducto(PublicacionProducto publicacionProducto) throws Exception;

}
