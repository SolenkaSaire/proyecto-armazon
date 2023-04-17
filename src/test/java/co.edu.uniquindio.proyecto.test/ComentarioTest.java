package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;
    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crear() throws Exception {

        LocalDateTime fechaActual = LocalDateTime.now();

        ComentarioDTO comentarioDTO = new ComentarioDTO("Hola",2,1,1);

        int guardado = comentarioServicio.crearComentario(comentarioDTO);

        ComentarioGetDTO comentario = comentarioServicio.obtenerComentario(guardado);

        Assertions.assertEquals("Hola", comentario.getTexto());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() throws Exception {

        ComentarioGetDTO comentario = comentarioServicio.obtenerComentario(1);

        ComentarioDTO comentarioDTO = new ComentarioDTO("Hola actualizado", comentario.getEstrellas(),
                comentario.getCodigoUsuario(), comentario.getCodigoPublicacionProducto());

        ComentarioGetDTO actualizado = comentarioServicio.actualizarComentario(1,comentarioDTO);

        Assertions.assertEquals("Hola actualizado", actualizado.getTexto());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() throws Exception {

        comentarioServicio.eliminarComentario(1);

        Assertions.assertNull(comentarioRepo.findById(1).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() throws Exception {

        ComentarioGetDTO comentario = comentarioServicio.obtenerComentario(1);

        Assertions.assertNotNull(comentario);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuario() throws Exception {

        List<ComentarioGetDTO> lista = comentarioServicio.listarComentarioUsuario(1);

        System.out.println(lista);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() throws Exception {

        List<ComentarioGetDTO> lista = comentarioServicio.listarComentarios(1);

        System.out.println(lista);

    }

}
