package co.edu.uniquindio.proyecto.servicios.implementacion;


import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.*;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
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

    private final PublicacionProductoServicio publicacionProductoServicio;
    private final UsuarioServicio usuarioServicio;
    private final PublicacionProductoRepo publicacionProductoRepo;
    private final EmailServicio emailServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(comentarioDTO.getCodigoPublicacionProducto());


        Comentario nuevoComentario= new Comentario();
        nuevoComentario.setFecha_creacion(LocalDateTime.now());
        nuevoComentario.setTexto(comentarioDTO.getTexto());
        nuevoComentario.setEstrellas(comentarioDTO.getEstrellas());
        nuevoComentario.setUsuario(usuarioServicio.obtenerUsuarioU(comentarioDTO.getCodigoUsuario()));
        nuevoComentario.setPublicacionProducto(publicacionProducto);

        System.out.println("El comentario es: "+ comentarioDTO.getTexto());

        String email= "<h1>Se ha añadido un nuevo mensaje a su publicacion</h1><h2><p>En tu producto de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'> <br>Resumen del Comentario:<br>Enviado por:" + nuevoComentario.getUsuario().getNombre() +"<br>Mensaje:"+nuevoComentario.getTexto();

        emailServicio.enviarEmail(new EmailDTO(
                "Correo creado",
                email,
                publicacionProducto.getVendedor().getEmail()));

        comentarioRepo.save(nuevoComentario);
        int cantidad = publicacionProducto.getComentarios().size();
        double promActual = publicacionProducto.getPromedioEstrellas();
        promActual= promActual * (cantidad-1);
        promActual+= nuevoComentario.getEstrellas();
        promActual = promActual/ cantidad;
        publicacionProducto.setPromedioEstrellas(promActual);

        if (publicacionProducto.getCodigo() == comentarioDTO.getCodigoPublicacionProducto()) {
            publicacionProducto.getComentarios().add(nuevoComentario);
            publicacionProductoRepo.save(publicacionProducto);
        }

        return nuevoComentario.getCodigo();
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoProducto, ComentarioDTO comentarioDTO) throws Exception {
        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(comentarioDTO.getCodigoPublicacionProducto());

        validarExiste(codigoProducto);
        Comentario comentario= convertir(comentarioDTO);
        comentario.setCodigo(codigoProducto);

        String email= "<h1>Se ha actualizado un comentario en su publicacion</h1><h2><p>En Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'> <br>Resumen del Comentario:<br>Enviado por:" + comentario.getUsuario().getNombre() +"<br>Mensaje:"+comentario.getTexto();

        emailServicio.enviarEmail(new EmailDTO(
                "Actualizacion de comentario",
                email,
                publicacionProducto.getVendedor().getEmail()));
        return convertir(comentarioRepo.save(comentario));
    }

    private Comentario convertir(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioDTO.getTexto());
        comentario.setFecha_creacion(LocalDateTime.now());
        comentario.setEstrellas(comentarioDTO.getEstrellas());
        comentario.setUsuario(usuarioServicio.obtenerUsuarioU(comentarioDTO.getCodigoUsuario()));
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
