package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;

import java.util.List;

public interface ProductoModeradorServicio {

    public List<PublicacionProductoGetDTO> listarPublicaciones();


}
