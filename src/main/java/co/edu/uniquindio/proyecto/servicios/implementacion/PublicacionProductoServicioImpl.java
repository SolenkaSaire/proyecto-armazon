package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublicacionProductoServicioImpl implements PublicacionProductoServicio {

    private final UsuarioServicio usuarioServicio;
    private final PublicacionProductoRepo publicacionProductoRepo;

    private final DetalleCompraServicio detalleCompraServicio;

    private final ProductoServicio productoServicio;
    @Override
    public int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception {
        //creacion del producto
        int codProducto;
        codProducto = productoServicio.crearProducto(productoDTO );
        //creacion de publicacion
        PublicacionProducto publicacionProducto= new PublicacionProducto();
        publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
        publicacionProducto.setFechaLimite(publicacionProductoDTO.getFechaLimite());

        publicacionProducto.setFecha_publicacion(LocalDateTime.now());

        publicacionProducto.setEstado(Estado.NO_REVISADO);
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
        publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
        publicacionProducto.setVendedor( usuarioServicio.obtenerUsuarioU( publicacionProductoDTO.getCodigoVendedor()));
        publicacionProducto.setFechaCreacion( LocalDateTime.now() );
        publicacionProducto.setFechaLimite( LocalDateTime.now().plusDays(60) );
        publicacionProducto.setProducto( productoServicio.obtenerProductoP( codProducto )  );

        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }

    @Override
    public int actualizarPublicacionProducto(int codigoPublicacion, PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) throws Exception {
        /**
         * TODO Validar que exista producto
         */
        int codProductoActualizado;
        codProductoActualizado = productoServicio.actualizarProducto(publicacionProductoDTO.getCodigoProducto(), productoDTO);
        /**
         * TODO Validar que exista publicacion
         */
        validarExiste(codigoPublicacion);
        PublicacionProducto publicacionProducto = convertir(publicacionProductoDTO);

        publicacionProducto.setCodigo(codigoPublicacion);
        publicacionProducto.setProducto( productoServicio.obtenerProductoP(codProductoActualizado) );
        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }


    private PublicacionProducto convertir(PublicacionProductoDTO publicacionProductoDTO) throws Exception {

        PublicacionProducto publicacionProducto = new PublicacionProducto();
        publicacionProducto.setEstado(Estado.NO_REVISADO);
        publicacionProducto.setFecha_publicacion(LocalDateTime.now());
        publicacionProducto.setPromedioEstrellas(publicacionProductoDTO.getPromedioEstrellas());
        publicacionProducto.setFechaCreacion(publicacionProductoDTO.getFechaLimite());
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setDisponibilidad(publicacionProductoDTO.getDisponibilidad());
        publicacionProducto.setDescripcion(publicacionProductoDTO.getDescripcion());
        publicacionProducto.setVendedor( usuarioServicio.obtenerUsuarioU( publicacionProductoDTO.getCodigoVendedor()));
        publicacionProducto.setFechaLimite( publicacionProductoDTO.getFechaLimite() );
        return publicacionProducto;
    }

    @Override
    public int actualizarUnidades(int codigoPublicacion, int unidades) throws Exception {
        PublicacionProducto publicacionProducto= obtenerPublicacionProductoP(codigoPublicacion);
        publicacionProducto.setDisponibilidad(unidades);
        return publicacionProductoRepo.save(publicacionProducto).getCodigo();
    }

    @Override
    public int eliminarPublicacion(int codigoPublicacion) throws Exception {
        validarExiste(codigoPublicacion);
        publicacionProductoRepo.deleteById(codigoPublicacion);
        return codigoPublicacion;
    }

    @Override
    public int eliminarTodaPublicacionProducto(int codigoProducto) throws Exception {
        Producto producto= productoServicio.obtenerProductoP( codigoProducto );

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == codigoProducto) {
                publicacionProductoRepo.deleteById( p.getCodigo() );
                break;
            }
        }

        return codigoProducto;
    }

    @Override
    public PublicacionProductoGetDTO obtenerPublicacionProducto(int codigoPublicacion) throws Exception {
        return convertir( obtenerPublicacionProductoP(codigoPublicacion) );
    }
    @Override
    public PublicacionProducto obtenerPublicacionProductoP(int codigoPublicacion) throws Exception{
        Optional<PublicacionProducto> publicacionProducto = publicacionProductoRepo.findById(codigoPublicacion);

        if(publicacionProducto.isEmpty() ){
            try {
                throw new Exception("El código "+codigoPublicacion+" no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return publicacionProducto.get();
    }

    @Override
    public List<PublicacionProductoGetDTO> listarProductosPublicacionUsuario(int codigoUsuario) throws Exception {
        List<PublicacionProducto> lista = publicacionProductoRepo.listarProductosUsuario(codigoUsuario);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for(PublicacionProducto p : lista){
            respuesta.add( convertir(p) );
        }
        return respuesta;
    }



    private PublicacionProductoGetDTO convertir(PublicacionProducto publicacionProducto) throws Exception {
        PublicacionProductoGetDTO publicacionProductoGetDTO = new PublicacionProductoGetDTO(
                publicacionProducto.getCodigo(),
                publicacionProducto.getPromedioEstrellas(),
                publicacionProducto.getFechaLimite(),
                publicacionProducto.getPrecio(),
                publicacionProducto.getDisponibilidad(),
                publicacionProducto.getDescripcion(),
                publicacionProducto.getVendedor().getCodigo(),
                publicacionProducto.getProducto().getCodigo(),
                publicacionProducto.getEstado().toString(),
                convertirProducto(publicacionProducto.getProducto()),
                convertirComentarios(publicacionProducto.getComentarios())
        );
        return publicacionProductoGetDTO;
    }
    private List<ComentarioGetDTO> convertirComentarios(List<Comentario> comentarios) throws Exception {
        List<ComentarioGetDTO> respuestas = new ArrayList<>();
        for (Comentario c:comentarios) {
            ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                    c.getTexto(),
                    c.getEstrellas(),
                    c.getUsuario().getCodigo(),
                    c.getPublicacionProducto().getCodigo()

            );
            respuestas.add(comentarioGetDTO);
        }

        return respuestas;
    }
    private ProductoGetDTO convertirProducto(Producto producto) throws Exception {
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getNombre(),
                productoServicio.convertirCategoria(producto.getCategoria()),
                producto.getImagenes(),
                productoServicio.convertirPublicaciones(producto.getPublicacionProductos()),
                productoServicio.convertirCiudades(producto.getCiudad())
        );
        return productoGetDTO;
    }


    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductoCategoria(Categoria categoria) throws Exception {
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosCategoria(categoria);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for (PublicacionProducto p :listaPublicaciones) {
            if (!p.getFechaLimite().isBefore(LocalDateTime.now())) {
                respuesta.add(convertir(p));
            }
        }
        return excluirEstados(respuesta);
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosPorEstado(String estado) throws Exception {
        Estado nuevoEstado = Estado.valueOf(estado);
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosEstado(nuevoEstado);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();

        for (PublicacionProducto p: listaPublicaciones) {
            if (!p.getFechaLimite().isBefore(LocalDateTime.now())) {
                respuesta.add(convertir(p));
            }
        }

        return respuesta;
    }

    public boolean tiempoLimite(PublicacionProducto publicacionProducto) {
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaLimite = publicacionProducto.getFechaLimite();

        return fechaActual.isAfter(fechaLimite);
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosFavoritos(int codigoUsuario) throws Exception {
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosFavoritos(codigoUsuario);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for (PublicacionProducto p: listaPublicaciones) {
            respuesta.add(convertir(p));
        }
        return excluirEstados(respuesta);
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosCiudad(Ciudad ciudad) throws Exception {
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.listarProductosCiudad(ciudad);
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();
        for (PublicacionProducto p :listaPublicaciones) {
            respuesta.add(convertir(p));

        }
        return excluirEstados(respuesta);
    }


    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosNombre(String nombre) throws Exception {
        List<PublicacionProducto> productos = publicacionProductoRepo.listarProductosNombre(nombre);
        List<PublicacionProductoGetDTO> respuesta= new ArrayList<>();

        for (PublicacionProducto p: productos) {
            respuesta.add(convertir(p));
        }

        return excluirEstados(respuesta);
    }

    @Override
    public List<PublicacionProductoGetDTO> listarPublicacionProductosPrecio(double precioMinimo, double precioMaximo) throws Exception {
        List<PublicacionProducto> lista = publicacionProductoRepo.listarProductoPrecio(precioMinimo, precioMaximo);
        List<PublicacionProductoGetDTO> respuesta= new ArrayList<>();

        for(PublicacionProducto p: lista){
            respuesta.add(convertir(p));
        }
        return excluirEstados(respuesta);
    }


    public void validarExiste(int codigoPublicacion) {
        boolean existe = publicacionProductoRepo.existsById(codigoPublicacion);
        if (!existe){
            try {
                throw new Exception("El código "+codigoPublicacion+" no está asociado a ninguna publicacion");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public List<PublicacionProductoGetDTO> excluirEstados(List<PublicacionProductoGetDTO> listaPublicaciones) {
        List<PublicacionProductoGetDTO> resultado = new ArrayList<>();

        for (PublicacionProductoGetDTO publicacion : listaPublicaciones) {
            Estado estado = Estado.valueOf(publicacion.getEstado());
            if (estado != Estado.NO_APROBADO && estado != Estado.NO_REVISADO) {
                resultado.add(publicacion);
            }
        }
        System.out.println("El correo es: "+ resultado);
        return resultado;
    }

    @Override
    public List<PublicacionProductoGetDTO> listarTodasLasPublicaciones() throws Exception {
        List<PublicacionProducto> listaPublicaciones = publicacionProductoRepo.findAll();
        List<PublicacionProductoGetDTO> respuesta = new ArrayList<>();

        for (PublicacionProducto p : listaPublicaciones) {
            respuesta.add(convertir(p));
        }

        return excluirEstados(respuesta);
    }


}
