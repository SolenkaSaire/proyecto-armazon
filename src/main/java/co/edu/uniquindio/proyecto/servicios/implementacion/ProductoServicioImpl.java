package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final PublicacionProductoRepo publicacionProductoRepo;
    ///cambios
    private final ModeradorServicio moderadorServicio;
    private final DetalleCompraServicio detalleCompraServicio;
    private final ComentarioServicio comentarioServicio;
    private final PublicacionProductoServicio publicacionProductoServicio;


    @Override
    public int crearProducto(ProductoDTO productoDTO, PublicacionProductoDTO publicacionProductoDTO) throws Exception{
        //producto: codigo;nombre;categoria;imagenes;publicacionProductos;
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategorias());
        producto.setImagenes(productoDTO.getImagenes());

        productoRepo.save(producto);

        PublicacionProducto publicacionProducto= new PublicacionProducto();
        publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
        publicacionProducto.setFechaLimite(publicacionProductoDTO.getFechaLimite());
        publicacionProducto.setEstado(Estado.NO_APROBADO);
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
        publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
        publicacionProducto.setVendedor( usuarioServicio.obtenerUsuario( publicacionProductoDTO.getCodigoVendedor()) );
        publicacionProducto.setProducto(producto);

        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }

    @Override
    public PublicacionProductoGetDTO actualizarProducto(int codigoPublicacion, PublicacionProductoDTO publicacionProductotDTO) {
            validarExiste(codigoPublicacion);
            //validarExiste( codigoprodcuto);
            Producto productoActualizado = obtenerProducto2( obtenerProducto(codigoPublicacion).getProducto().getCodigo() );
            productoActualizado.setNombre( obtenerProducto2(publicacionProductotDTO.getCodigoProducto()).getNombre() );
            productoActualizado.setCategoria( obtenerProducto2(publicacionProductotDTO.getCodigoProducto()).getCategoria()  );
            productoActualizado.setImagenes( obtenerProducto2(publicacionProductotDTO.getCodigoProducto()).getImagenes() );


            PublicacionProducto p = new PublicacionProducto();
            PublicacionProducto publicacionProducto = obtenerProducto(codigoPublicacion);
            //publicacionProducto.set....
            publicacionProducto.setPromedioEstrellas( publicacionProductotDTO.getPromedioEstrellas() );
            publicacionProducto.setFechaLimite( publicacionProductotDTO.getFechaLimite() );
            publicacionProducto.setPrecio( publicacionProductotDTO.getPrecio() );
            publicacionProducto.setDisponibilidad(  publicacionProductotDTO.getDisponibilidad() );
            publicacionProducto.setProducto( productoActualizado );

        return convertir(publicacionProductoRepo.save(publicacionProducto));
    }

    @Override
    public Producto obtenerProducto2(int codigoProducto) {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);
        if(producto.isEmpty() ){
            try {
                throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return producto.get();

    }

    private PublicacionProductoGetDTO convertir(PublicacionProducto publicacionProducto) throws Exception {
        //////////////////////////codigo;fecha_publi;promedioE; fecha_creaci;fecha_limite;precio;disponibilidad, descripcion; vendedor;
        PublicacionProductoGetDTO publicacionProductoDTO = new PublicacionProductoGetDTO(
                publicacionProducto.getPromedioEstrellas(),
                publicacionProducto.getFechaLimite(),
                publicacionProducto.getPrecio(),
                publicacionProducto.getDisponibilidad(),
                publicacionProducto.getDescripcion(),
                publicacionProducto.getVendedor().getCodigo(),
                usuarioServicio.obtenerUsuariosCodigo( publicacionProducto.getFavoritos() ),
                moderadorServicio.obtenerModeradoresCodigo( publicacionProducto.getModeradores()),
                detalleCompraServicio.obtenerDetallesCodigo( publicacionProducto.getCompras() ),
                comentarioServicio.obtenerListaComentarios( publicacionProducto.getComentarios() ),
                publicacionProducto.getProducto().getCodigo(),
                publicacionProducto.getEstado().toString(),
                publicacionProductoServicio.obtenerCiudadesCodigo( publicacionProducto.getCiudades() )
                );
            return publicacionProductoDTO;

    }

    private void validarExiste(int codigoPublicacion) {
        boolean existe = publicacionProductoRepo.existsById(codigoPublicacion);
        if (!existe){
            try {
                throw new Exception("El código "+codigoPublicacion+" no está asociado a ninguna publicacion");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    private PublicacionProducto convertir(PublicacionProductoDTO publicacionProductoDTO){
        PublicacionProducto publicacionProducto = new PublicacionProducto();
//////////////////////////codigo;nombre;categoria;imagenes;publicacionProductos;
                /*publicacionProducto.getProducto().setCodigo(publicacionProductoDTO.getProducto().getCodigo());
                publicacionProducto.getProducto().setNombre(publicacionProductoDTO.getProducto().getNombre());
                publicacionProducto.getProducto().setCategoria(publicacionProductoDTO.getProducto().getCategoria());
                publicacionProducto.getProducto().setImagenes(publicacionProductoDTO.getProducto().getImagenes());
                publicacionProducto.setCodigo(publicacionProductoDTO.getCodigo());
              //  publicacionProducto.setFecha_publicacion(publicacionProductoDTO.getFecha_publicacion());
                publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
             //   publicacionProducto.setFechaCreacion(publicacionProductoDTO.getFechaCreacion());
                publicacionProducto.setFechaLimite(publicacionProductoDTO.getFechaLimite());
                publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
                publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
                publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
                publicacionProducto.setVendedor(publicacionProductoDTO.getVendedor());*/

        return publicacionProducto;
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

        PublicacionProducto publicacionProducto = obtenerProducto(codigoProducto);
        publicacionProducto.setEstado(estado);

        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
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
    public List<PublicacionProductoGetDTO> listarPublicacionProductosUsuario(int codigoUsuario) {

        List<PublicacionProducto> listaProductos = publicacionProductoRepo.listarProductosUsuario(codigoUsuario);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
       // List<ProductoGetDTO> respuestaProductos = new ArrayList<>();

        for (PublicacionProducto p :listaProductos) {
            respuesta.add(convertir(p));
           // respuestaProductos.add(convertirProducto(p.getProducto()));
        }
        return respuesta;
    }


    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosCategoria(Categoria categoria) {

        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosCategoria(categoria);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for (PublicacionProducto p :listaPublicaciones) {
            respuesta.add(convertir(p));

        }
        return respuesta;

    }


    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(Estado estado) {

        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosEstado(estado);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();

        for (PublicacionProducto p: listaPublicaciones) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionesProductosFavoritos(int codigoUsuario) {

        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosFavoritos(codigoUsuario);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for (PublicacionProducto p: listaPublicaciones) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre) {
        List<PublicacionProducto> productos = publicacionProductoRepo.listarProductosNombre(nombre);
        List<PublicacionProductoGetDTO> respuesta= new ArrayList<>();

        for (PublicacionProducto p: productos) {
         respuesta.add(convertir(p));
        }

        return respuesta;
    }



    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(double precioMinimo, double precioMaximo) {

        List<PublicacionProducto> lista = publicacionProductoRepo.listarProductoPrecio(precioMinimo, precioMaximo);
        List<PublicacionProductoGetDTO> respuesta= new ArrayList<>();

            for(PublicacionProducto p: lista){
              respuesta.add(convertir(p));
            }
        return respuesta;
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductoCiudad(String ciudad){
        List<PublicacionProducto> lista = publicacionProductoRepo.listarProductoCiudad(ciudad);
        List<PublicacionProductoGetDTO> respuesta= new ArrayList<>();
        for(PublicacionProducto p: lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }



}
