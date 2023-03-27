package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Categoria;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;

import java.util.List;

public interface ProductoServicio {


    int crearProducto(ProductoDTO productoDTO);

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);

    int actualizarUnidades(int codigoProducto, int unidades);

    int actualizarEstado(int codigoProducto, Estado estado);

    int eliminarProducto(int codigoProducto);

    ProductoGetDTO obtenerProducto(int codigoProducto);

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

}