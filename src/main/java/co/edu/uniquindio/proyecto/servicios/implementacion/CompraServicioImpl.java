package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    private final PublicacionProductoServicio publicacionProductoServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) {
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
}
