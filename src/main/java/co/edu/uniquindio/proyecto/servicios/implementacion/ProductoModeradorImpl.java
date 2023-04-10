package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorServicio;

import java.util.ArrayList;
import java.util.List;

public class ProductoModeradorImpl implements ProductoModeradorServicio {

    PublicacionProductoRepo publicacionProductoRepo;

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

    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicaciones() {
        List<PublicacionProducto> registros = publicacionProductoRepo.findAll();
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();

        for (PublicacionProducto p : registros){
            respuesta.add(convertir(p));
        }
        return  respuesta;
    }


}
