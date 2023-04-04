package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;

public interface ModeradorServicio {


    void aprobarProducto(PublicacionProducto publicacionProducto) throws Exception;

    void rechazarProducto(PublicacionProducto publicacionProducto) throws Exception;
}
