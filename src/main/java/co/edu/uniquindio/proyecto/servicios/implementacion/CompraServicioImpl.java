package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final UsuarioServicio usuarioServicio;
    private final EmailServicio emailServicio;
    private final PublicacionProductoServicio publicacionProductoServicio;
    private final DetalleCompraServicio detalleCompraServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        List<DetalleCompra> detalle = new ArrayList<>();
        double total = 0;

        Usuario comprador = new Usuario();
        Set<String> emails = new HashSet<>();

        for (DetalleCompraDTO de : compraDTO.getDetalleCompraDTO()) {
            DetalleCompra detalleCompra = new DetalleCompra();
            PublicacionProducto pp = publicacionProductoServicio.obtenerPublicacionProductoP(de.getCodigoPublicacionProducto());
            detalleCompra.setPublicacionProducto(pp);

            detalleCompra.setUnidades(de.getUnidades());
            detalleCompra.setPrecio(pp.getPrecio());
            total += pp.getPrecio() * de.getUnidades();
            detalle.add(detalleCompra);

            emails.add(pp.getVendedor().getEmail());

        }
        Compra compra = new Compra();
        compra.setUsuario(usuarioServicio.obtenerUsuarioU(compraDTO.getCodigoUsuario()));
        compra.setFecha_creacion(LocalDateTime.now());
        compra.setMetodoPagos(compraDTO.getMetodoPago());
        compra.setTotal(total);
        Compra compraGuardada = compraRepo.save(compra);
        for (DetalleCompra d : detalle) {
            d.setCompra(compraGuardada);
            detalleCompraRepo.save(d);
        }
        String emailVendedor= "<h1>Has vendido un producto</h1><h2><p>En la pagian de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'>";
        String emailComprador= "<h1>Has comprado un producto en la pagina de Armazon</h1><h2><p>¡¡Felicidades!!</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'>";

        comprador = usuarioServicio.obtenerUsuarioU(compraDTO.getCodigoUsuario());
        String emailC = comprador.getEmail();


        for (String email : emails) {
            EmailDTO emailDTO = new EmailDTO("Producto vendido", emailVendedor, email);
            emailServicio.enviarEmail(emailDTO);
        }
        EmailDTO emailDTO = new EmailDTO("Producto comprado", emailComprador, emailC);
        emailServicio.enviarEmail(emailDTO);

        return compraGuardada.getCodigo();
    }




    private CompraGetDTO convertir(Compra compra) {
        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getTotal(),
                compra.getMetodoPagos(),
                compra.getUsuario().getCodigo(),
                compra.getPublicacionProductos()
        );
        return compraGetDTO;
    }


    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception {
        return convertir(obtenerU(codigoCompra));
    }


    private Compra obtenerU(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        if (compra.isEmpty()) {
            try {
                throw new Exception("El código " + codigoCompra + " no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("compra existe");
        return compra.get();
    }
}
