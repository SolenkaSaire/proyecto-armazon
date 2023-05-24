package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.*;

import java.util.List;

public interface ProductoServicio {



    int crearProducto(ProductoDTO productoDTO) throws Exception;

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    Producto obtenerProductoP(int codigoProducto) throws Exception;

    List<Integer> convertirPublicaciones(List<PublicacionProducto> publicaciones);

    List<String> convertirCategoria(List<Categoria> categorias);

    List<String> convertirCiudades(List<Ciudad> ciudades);

    public List<Categoria> listarCategorias() throws Exception;

    List<Ciudad> listarCiudades() throws Exception;
}