package co.edu.uniquindio.proyecto.servicios.implementacion;


import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.jakarta.persistence.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
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
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO, int codigoProducto, String comentario) throws Exception {
        PublicacionProducto publicacionProducto = new PublicacionProducto();
        Comentario comentarios= new Comentario(comentario);
        for (Comentario p : publicacionProducto.getComentarios()) {
            if (publicacionProducto.getCodigo() == codigoProducto) {
                p.getPublicacionProducto().getComentarios().add(comentarios );
                break;
            }
        }

        return comentarios.getCodigo();
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) throws Exception {
        validarExiste(codigoProducto);
        Comentario comentario= convertir(comentarioDTO);
        comentario.setCodigo(codigoProducto);
        return convertir(comentarioRepo.save(comentario));
    }

    private Comentario convertir(ComentarioDTO comentarioDTO) {

        Comentario comentario = new Comentario();
        comentario.setCodigo(comentarioDTO.getCodigo());
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

    private ComentarioGetDTO convertir(Comentario comentario){
    //codigo, fecha, mensaje, codigoUsuario, codigoProducto
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFecha_creacion(),
                comentario.getTexto(),
                comentario.getUsuario().getCodigo(),
                comentario.getPublicacionProducto().getProducto().getCodigo()
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
