package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.Categoria;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final PublicacionProductoRepo publicacionProductoRepo;


    @Override
    public int crearProducto(ProductoDTO productoDTO, PublicacionProductoDTO publicacionProductoDTO) throws Exception{
        //producto: codigo;nombre;categoria;imagenes;publicacionProductos;
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategorias());//como ahi
        producto.setImagenes(productoDTO.getImagenes());

//codigo;fecha_publicacion;promedioEstrellas;fechaCreacion;fechaLimite;precio;disponibilidad;descripcion, Usuario, vendedor
//  List<Usuario> favoritos;List<ProductoModerador> moderadores;List<DetalleCompra> compras;  List<Comentario> comentarios;
        //Estado estado; List<Ciudad> ciudades;

        PublicacionProducto publicacionProducto= new PublicacionProducto();
        publicacionProducto.setFecha_publicacion(publicacionProductoDTO.getFecha_publicacion());
        publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
       // publicacionProducto.setFechaCreacion(publicacionProductoDTO.getFechaCreacion());
        publicacionProducto.setFechaLimite(publicacionProductoDTO.getFechaLimite());
        publicacionProducto.setEstado(publicacionProductoDTO.getEstado());
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
        publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
        publicacionProducto.setCiudades(publicacionProductoDTO.getCiudad());
        publicacionProducto.setVendedor(publicacionProductoDTO.getVendedor());

       // return publicacionProductoRepo.save( publicacionProducto ).getCodigo();//esto? voy a mirar
//tenemos varios errores, ahi en las excepciones dice que en usuarioRepo utilizamos correo, y usuario tiene email, no correo

        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
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
        List<Producto> productos = productoRepo.listarProductosNombre(nombre);
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
