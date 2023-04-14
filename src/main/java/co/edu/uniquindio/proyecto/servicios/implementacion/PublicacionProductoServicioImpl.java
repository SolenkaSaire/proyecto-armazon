package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.modelo.Ciudad;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicacionProductoServicioImpl implements PublicacionProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final PublicacionProductoRepo publicacionProductoRepo;
    ///cambios
    private final ModeradorServicio moderadorServicio;
    private final DetalleCompraServicio detalleCompraServicio;
    private final ComentarioServicio comentarioServicio;
    private final ProductoServicio productoServicio;
    @Override
    public int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO) throws Exception {


        //return productoRepo.save(producto).getCodigo();
        PublicacionProducto publicacionProducto= new PublicacionProducto();
        publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
        publicacionProducto.setFechaLimite(publicacionProductoDTO.getFechaLimite());
        publicacionProducto.setEstado(Estado.NO_APROBADO);
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
        publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
        publicacionProducto.setVendedor( usuarioServicio.obtenerUsuario( publicacionProductoDTO.getCodigoVendedor());
        publicacionProducto.setFechaCreacion( LocalDateTime.now() );
        publicacionProducto.setFechaLimite( LocalDateTime.now().plusDays(60) );
       // Producto producto = new Producto();
        int producto;
        producto = productoServicio.crearProducto( productoServicio.obtenerProducto(  publicacionProductoDTO.getCodigoProducto() )   );
        //publicacionProducto.setProducto(producto);



        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }

    @Override
    public List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades) {
        List<Integer> codigosCiudades = new ArrayList<>();
        for (Ciudad c: ciudades) {
            codigosCiudades.add( c.getCodigo() );

        }
        return codigosCiudades;
    }
}
