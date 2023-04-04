package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private final ModeradorRepo moderadorRepo;
    private final ProductoServicio productoServicio;
    //private final ProductoModeradorRepo productoModeradorRepo;

    @Override
    public void aprobarProducto(PublicacionProducto publicacionProducto) throws Exception{
        publicacionProducto.setEstado(Estado.APROBADO);
    }

    @Override
    public void rechazarProducto(PublicacionProducto publicacionProducto) throws Exception{
        publicacionProducto.setEstado(Estado.NO_APROBADO);
    }

    /*
    @Override
    public void aprobarProducto(EstadoDTO estadoDTO) throws Exception{
        cambiarEstado(estadoDTO, Estado.APROBADO);
    }

    @Override
    public void rechazarProducto(EstadoDTO estadoDTO) throws Exception{
        cambiarEstado(estadoDTO, Estado.NO_APROBADO);
    }

    private int cambiarEstado(EstadoDTO estadoDTO, Estado estado) throws Exception{

        return 1;

    }*/

}
