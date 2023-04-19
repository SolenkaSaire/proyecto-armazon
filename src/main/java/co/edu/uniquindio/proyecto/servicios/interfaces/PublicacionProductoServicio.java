package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
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

    List<PublicacionProductoGetDTO> listarPublicacionProductoCategoria(Categoria categoria) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(Estado estado) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosFavoritos(int codigoUsuario) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(float precioMinimo, float precioMaximo) throws Exception;
    List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades);
    void validarExiste(int codigoPublicacion);
}

