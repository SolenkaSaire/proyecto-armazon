package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.modelo.ProductoModerador;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio{
    private  final PublicacionProductoRepo publicacionProductoRepo;
    private final ModeradorRepo moderadorRepo;
    //cambios
    //private final PublicacionProductoServicio publicacionProductoServicio;
    @Override
    public void aprobarProducto(PublicacionProducto publicacionProducto, ProductoModerador productoModerador){
        publicacionProducto.setEstado(Estado.APROBADO);

        //productoModerador

    }

    @Override
    public void rechazarProducto(PublicacionProducto publicacionProducto) {
        publicacionProducto.setEstado(Estado.NO_APROBADO);
    }

/*
    private PublicacionProductoGetDTO convertir(PublicacionProducto p) {
        PublicacionProductoGetDTO publicacionProductoGetDTO= new PublicacionProductoGetDTO(
            p.getCodigo(),
                p.getFecha_publicacion(),
                p.getPromedioEstrellas(),
                p.getFechaCreacion(),
                p.getFechaLimite(),
                p.getPrecio(),
                p.getDisponibilidad(),
                p.getDescripcion(),
                p.getVendedor(),
                p.getProducto()


            );
        return publicacionProductoGetDTO;

    }*/

}
