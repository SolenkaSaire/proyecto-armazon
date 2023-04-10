package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

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
    public List<CompraGetDTO> listarCompras(int codigoProducto) {
        List<Compra> lista = compraRepo.listarCompras(codigoProducto);
        List<CompraGetDTO> respuesta = new ArrayList<>();
        for (Compra p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;

    }


    private CompraGetDTO convertir(Compra compra){
        //codigo, fecha, total, codigoUsuario, metodoPago, list<>drtalleCompraDTO
        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFecha_creacion(),
                compra.getTotal(),
                compra.getUsuario().getCodigo(),
                compra.getMetodoPagos(),
                compra.getPublicacionProductos()
        );
        return compraGetDTO;
    }


    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception {
        return convertir(obtener(codigoCompra));
    }


    private Compra obtener(int codigoCompra) throws Exception{
    Optional<Compra> compras = compraRepo.findById(codigoCompra);

        if(compras.isEmpty()){
            try {
                throw new Exception("El código "+codigoCompra+" no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return compras.get();
    }

}
