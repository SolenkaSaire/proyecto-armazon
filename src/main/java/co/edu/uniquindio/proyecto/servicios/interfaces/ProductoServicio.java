package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;

import java.util.List;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO, PublicacionProductoDTO publicacionProductoDTO) throws Exception;
    PublicacionProductoGetDTO actualizarProducto(int codigoPublicacion, PublicacionProductoDTO publicacionProductotDTO);
    int actualizarUnidades(int codigoProducto, int unidades);
    int actualizarEstado(int codigoProducto, Estado estado);
    int eliminarProducto(int codigoProducto);
    PublicacionProducto obtenerProducto(int codigoProducto);
    Producto obtenerProducto2(int codigoProducto);
        List<PublicacionProductoGetDTO> listarPublicacionProductosUsuario(int codigoUsuario);
    List<PublicacionProductoGetDTO> listarPublicacionProductosCategoria(Categoria categoria);
    List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(Estado estado);
    public List<PublicacionProductoGetDTO> listarPublicacionesProductosFavoritos(int codigoUsuario);
    public List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre);
    public List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(double precioMinimo, double precioMaximo);
    public List<PublicacionProductoGetDTO> listarPublicacionProductoCiudad(String ciudad);

}