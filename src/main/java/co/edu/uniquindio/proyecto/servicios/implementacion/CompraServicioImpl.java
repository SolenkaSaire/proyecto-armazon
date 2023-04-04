package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Compra;
import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }

/*
    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    //private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    //private final PublicacionProductoServicio publicacionProductoServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) {//throws Exception {

        List<DetalleCompra> detalle = new ArrayList<>();
        double total = 0;
        for(DetalleCompraDTO de : compraDTO.getDetalleCompraDTO()){
            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setPublicacionProducto(productoServicio.obtenerProducto( de.getCodigoProducto() ));
            detalleCompra.setUnidades( de.getUnidades() );
            detalleCompra.setPrecio( de.getPrecio() );
            total = de.getPrecio() * de.getUnidades();

            detalle.add(detalleCompra);
        }

        Compra compra = new Compra();
        //compra.setUsuario( usuarioServicio.obtenerUsuario( compraDTO.getCodigoUsuario()));
        compra.setFecha_creacion(LocalDateTime.now());
        compra.setMetodoPagos( compraDTO.getMetodoPago() );
        compra.setTotal( total );

        Compra compraGuardada = compraRepo.save(compra);

        for (DetalleCompra d: detalle ) {
            d.setCompra(compraGuardada);
            detalleCompraRepo.save(d);

        }
        return compraGuardada.getCodigo();
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        List<Compra> compras = compraRepo.findByCodigoUsuario(codigoUsuario);List<CompraGetDTO> comprasDTO = new ArrayList<>();
        /*
        for (Compra compra : compras) {
            CompraGetDTO compraDTO = new CompraGetDTO();
            compraDTO.setCodigo(compra.getCodigo());
            compraDTO.setMetodoPago(compra.getMetodoPagos());
            compraDTO.setTotal(compra.getTotal());
            compraDTO.setFecha(compra.getFecha_creacion());
            List<DetalleCompraGetDTO> detallesDTO = new ArrayList<>();
            for (DetalleCompra detalle : compra.getPublicacionProductos() ) {//getDetalleCompra<List>
                DetalleCompraGetDTO detalleDTO = new DetalleCompraGetDTO();
                detalleDTO.setCodigoProducto(detalle.getPublicacionProducto().getCodigo());
                detalleDTO.setNombreProducto(detalle.getPublicacionProducto().getNombre());
                detalleDTO.setPrecio(detalle.getPrecio());
                detalleDTO.setUnidades(detalle.getUnidades());
                detallesDTO.add(detalleDTO);
            }
            compraDTO.setDetalleCompra(detallesDTO);
            comprasDTO.add(compraDTO);
        }
        */
/*
        return comprasDTO;

    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }

 */
}
