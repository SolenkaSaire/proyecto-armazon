package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;

import java.util.List;

public interface ModeradorServicio {



    void aprobarProducto(PublicacionProducto publicacionProducto) throws Exception;

    void rechazarProducto(PublicacionProducto publicacionProducto) throws Exception;

    List<PublicacionProductoGetDTO> listarEstado(Estado estado) throws Exception;
}
