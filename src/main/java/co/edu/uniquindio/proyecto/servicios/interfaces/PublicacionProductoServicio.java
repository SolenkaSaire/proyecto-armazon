package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.*;

import java.util.List;

public interface PublicacionProductoServicio {


    int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception;
    int actualizarPublicacionProducto(int codigoPublicacion,PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception;
    int actualizarUnidades(int codigoPublicacion, int unidades) throws Exception;
    int eliminarPublicacion(int codigoPublicacion) throws Exception;
    int eliminarTodaPublicacionProducto(int codigoProducto) throws Exception;
    PublicacionProductoGetDTO obtenerPublicacionProducto(int codigoPublicacion) throws Exception;
    abstract PublicacionProducto obtenerPublicacionProductoP(int codigoPublicacion) throws Exception;
    List<PublicacionProductoGetDTO> listarProductosPublicacionUsuario(int codigoUsuario) throws Exception;

    List<PublicacionProductoGetDTO> listarPublicacionProductoCategoria(Categoria categoria) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(String estado) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosFavoritos(int codigoUsuario) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosCiudad(Ciudad ciudad) throws Exception;

    List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre) throws Exception;
    List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(double precioMinimo, double precioMaximo) throws Exception;

    List<PublicacionProductoGetDTO> listarTodasLasPublicaciones()throws Exception;

}

