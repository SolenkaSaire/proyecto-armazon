package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Categoria;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;


    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception{
        /*Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCodigo(productoDTO.getCodigoVendedor());
        producto.setCategoria(producto.getCategoria());
        producto.setCiudad(producto.getCiudad());
        producto.setEstado(producto.getEstado());
        producto.setPublicacionProductos(producto.getPublicacionProductos());
        producto.setImagenes(producto.getImagenes());*/

        //return productoRepo.save(productoDTO);
        return 0;
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) {
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {
        List<Producto> productos = productoRepo.listarPorNombre(nombre);
        List<ProductoGetDTO> respuesta= new ArrayList<>();

        for (Producto p: productos) {
            //respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }
}
