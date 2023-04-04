package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.*;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        publicacionProducto.setEstado(Estado.NO_APROBADO);
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
    public int actualizarProducto(int codigoProducto, ProductoGetDTO productoGetDTO, PublicacionProductoDTO publicacionProductoDTO) {
            Producto producto= new Producto();

            for (PublicacionProducto p :producto.getPublicacionProductos() ) {
                if (producto.getCodigo() == codigoProducto) {
                   p.setDescripcion(null);
                   p.getProducto().setNombre(null);
                   p.getProducto().setImagenes(null);
                   p.getProducto().setCategoria(null);
                   p.setDescripcion(null);
                   p.setEstado(null);
                   p.setDisponibilidad(0);
                   p.setPrecio(0);
                   p.setCiudades(null);
                   p.setFechaLimite(null);
                    p.setVendedor(null);
                    p.setFechaCreacion(null);
                    p.setPromedioEstrellas(null);
                    p.setModeradores(null);
                    p.setFavoritos(null);
                    p.setFecha_publicacion(null);
                    p.setCompras(null);



                break;
                }
            }


        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) {
        Producto producto= new Producto();

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == codigoProducto) {
                p.setDisponibilidad(unidades);
                break;
            }
        }


        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) {
        Producto producto= new Producto();

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == codigoProducto) {
                p.setEstado(estado);
                break;
            }
        }
        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        Producto producto= new Producto();

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == codigoProducto) {
               producto.getPublicacionProductos().remove(p);
                break;
            }
        }

        return 0;

    }

    @Override
    public PublicacionProducto obtenerProducto(int codigoProducto) {

        Optional<PublicacionProducto> publicacionProducto = publicacionProductoRepo.findById(codigoProducto);

        if(publicacionProducto.isEmpty() ){
            try {
                throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return publicacionProducto.get();

     }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {

        List<Producto> listaProductos = productoRepo.listarProductosUsuario(codigoUsuario);
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(int i = 0; i < listaProductos.size(); i++){
            respuesta.add( convertir(listaProductos.get(i), listaPublicaciones.get(i)) );
        }

        return respuesta;
    }


    private ProductoGetDTO convertir(Producto producto, PublicacionProducto publicacionProducto){
        //PRODUCTO
//////codigo;nombre;categoria;imagenes;publicacionProductos
        //PUBLICACION
// codigo;fecha_publicacion;promedioEstrellas;fechaCreacion;fechaLimite;precio;disponibilidad;descripcion, Usuario, vendedor
//  List<Usuario> favoritos;List<ProductoModerador> moderadores;List<DetalleCompra> compras;  List<Comentario> comentarios;
        //Estado estado; List<Ciudad> ciudades;

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                publicacionProducto.getEstado(),
                publicacionProducto.getFechaLimite(),
                producto.getNombre(),
                publicacionProducto.getDescripcion(),
                publicacionProducto.getDisponibilidad(),
                publicacionProducto.getPrecio(),
                publicacionProducto.getVendedor().getCodigo(),
                producto.getImagenes(),
                producto.getCategoria()
        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {

        List<Producto> listaProductos = productoRepo.listarProductosCategoria(categoria);
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(int i = 0; i < listaProductos.size(); i++){
            respuesta.add( convertir(listaProductos.get(i), listaPublicaciones.get(i)) );
        }

        return respuesta;

    }


    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {

        List<Producto> listaProductos = productoRepo.listarProductosEstado(estado);
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(int i = 0; i < listaProductos.size(); i++){
            respuesta.add( convertir(listaProductos.get(i), listaPublicaciones.get(i)) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        //usuarioServicio.validarExiste(codigoUsuario);
        //return convertir(productoRepo.listarProductosFavoritos(codigoUsuario));
        List<Producto> listaProductos = productoRepo.listarProductosFavoritos(codigoUsuario);
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();
        for(int i = 0; i < listaProductos.size(); i++){
            respuesta.add( convertir(listaProductos.get(i), listaPublicaciones.get(i)) );
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {
        List<Producto> productos = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta= new ArrayList<>();

        for (Producto p: productos) {
         //   respuesta.add(convertir(p));
        }

        return respuesta;
        //return convertir(productoRepo.listarProductosNombre(nombre));
    }



    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo, int codigo) {

        List<Producto> lista = productoRepo.listarProductoPrecio(codigo);
        List<ProductoGetDTO> respuesta= new ArrayList<>();

            for(Producto p: lista){
              //  respuesta.add(convertir());
            }



        return respuesta;
    }


}
