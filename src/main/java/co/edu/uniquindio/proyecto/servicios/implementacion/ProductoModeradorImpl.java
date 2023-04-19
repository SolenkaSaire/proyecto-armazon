package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoModeradorImpl implements ProductoModeradorServicio {

    PublicacionProductoRepo publicacionProductoRepo;
    //cambios
    PublicacionProductoServicio publicacionProductoServicio;
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
