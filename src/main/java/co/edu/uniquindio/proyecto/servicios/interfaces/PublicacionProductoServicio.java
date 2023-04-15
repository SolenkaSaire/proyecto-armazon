package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.*;

import java.util.List;

public interface PublicacionProductoServicio {


    int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception;
    int actualizarPublicacionProducto(int codigoPublicacion,PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception;
    int actualizarUnidades(int codigoPublicacion, int unidades) throws Exception;
    int actualizarEstado(int codigoPublicacion, Estado estado) throws Exception;
    int eliminarPublicacion(int codigoPublicacion) throws Exception;
    int eliminarTodaPublicacionProducto(int codigoProducto) throws Exception;
    PublicacionProductoGetDTO obtenerPublicacionProducto(int codigoPublicacion) throws Exception;
    abstract PublicacionProducto obtenerPublicacionProductoP(int codigoPublicacion) throws Exception;
    List<PublicacionProductoGetDTO> listarProductosPublicacionUsuario(int codigoUsuario) throws Exception;
    PublicacionProductoGetDTO convertir(PublicacionProducto publicacionProducto) throws Exception;

    List<String> obtenerListaComentarios(List<Comentario> comentarios);

    List<PublicacionProductoGetDTO> listarPublicacionProductoCategoria(Categoria categoria) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(Estado estado) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosFavoritos(int codigoUsuario) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(float precioMinimo, float precioMaximo) throws Exception;
    List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades);
    void validarExiste(int codigoPublicacion);
}

