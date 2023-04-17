package co.edu.uniquindio.proyecto.servicios.implementacion;


import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.*;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    /*
    private final UsuarioRepo usuarioRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private  final ProductoRepo productoRepo;
*/
    private final PublicacionProductoServicio publicacionProductoServicio;
    private final UsuarioServicio usuarioServicio;
    private final PublicacionProductoRepo publicacionProductoRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(comentarioDTO.getCodigoPublicacionProducto());
        Comentario nuevoComentario= new Comentario();
        nuevoComentario.setFecha_creacion(LocalDateTime.now());
        nuevoComentario.setTexto(comentarioDTO.getTexto());
        nuevoComentario.setEstrellas(comentarioDTO.getEstrellas());
        nuevoComentario.setUsuario(usuarioServicio.obtenerUsuario(comentarioDTO.getCodigoUsuario()));
        nuevoComentario.setPublicacionProducto(publicacionProductoServicio.obtenerPublicacionProductoP(comentarioDTO.getCodigoPublicacionProducto()));
        comentarioRepo.save(nuevoComentario);
        double promedio=0;
        /*for (Comentario p : publicacionProducto.getComentarios() ) {
            promedio+= p.getEstrellas();
        }*/
        for (int i = 0; i < publicacionProducto.getComentarios().size()-1; i++) {
            Comentario aux = publicacionProducto.getComentarios().get(i);
            promedio+=aux.getEstrellas();
            if(publicacionProducto.getComentarios().size()-1==i){
                promedio=promedio/5;
                publicacionProducto.setPromedioEstrellas(promedio);
            }
        }

        if (publicacionProducto.getCodigo() == comentarioDTO.getCodigoPublicacionProducto()) {
            publicacionProducto.getComentarios().add(nuevoComentario);
            publicacionProductoRepo.save(publicacionProducto);
        }

        return nuevoComentario.getCodigo();
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) throws Exception {
        validarExiste(codigoProducto);
        Comentario comentario= convertir(comentarioDTO);
        comentario.setCodigo(codigoProducto);
        return convertir(comentarioRepo.save(comentario));
    }

    private Comentario convertir(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioDTO.getTexto());
        comentario.setEstrellas(comentarioDTO.getEstrellas());
        comentario.setUsuario(usuarioServicio.obtenerUsuario(comentarioDTO.getCodigoUsuario()));
        comentario.setPublicacionProducto(publicacionProductoServicio.obtenerPublicacionProductoP(comentarioDTO.getCodigoPublicacionProducto()));

        return comentario;
    }

    @Override
    public int eliminarComentario(int codigoProducto) throws Exception {
        validarExiste(codigoProducto);
        comentarioRepo.deleteById(codigoProducto);
        return codigoProducto;
    }
    private void validarExiste(int codigoProducto) throws Exception{
        boolean existe = comentarioRepo.existsById(codigoProducto);

        if( !existe ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún comentario");
        }

    }



    @Override
    public List<ComentarioGetDTO> listarComentarioUsuario(int codigoUsuario) {
        List<Comentario> lista = comentarioRepo.listarComentarioUsuario(codigoUsuario);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();
        for (Comentario p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoPublicacion) {
        List<Comentario> lista = comentarioRepo.listarComentariosPublicacion(codigoPublicacion);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();
        for (Comentario p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    private ComentarioGetDTO convertir(Comentario comentario){
    //codigo, fecha, mensaje, codigoUsuario, codigoProducto
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getTexto(),
                comentario.getEstrellas(),
                comentario.getUsuario().getCodigo(),
                comentario.getPublicacionProducto().getCodigo()
        );
        return comentarioGetDTO;
    }


    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return convertir(obtener(codigoComentario));
    }


    private Comentario obtener(int codigoComentario) throws Exception{
        Optional<Comentario> comentarios = comentarioRepo.findById(codigoComentario);

        if(comentarios.isEmpty()){
            try {
                throw new Exception("El código "+codigoComentario+" no está asociado a ningún producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return comentarios.get();
    }
}
