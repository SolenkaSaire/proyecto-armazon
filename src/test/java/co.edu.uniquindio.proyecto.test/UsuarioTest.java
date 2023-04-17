 package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 @DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE )
 */
 @SpringBootTest
 @Transactional
public class UsuarioTest {


 @Autowired
 private UsuarioRepo usuarioRepo;
 @Autowired
 private UsuarioServicio usuarioServicio;


     @Test
    public void registar() throws Exception {

         LocalDateTime fechaActual = LocalDateTime.now();

         String[] comentarios = new String[] {"Perro","Gato","Terreneitor"};
         Integer[] publicaciones = new Integer[] {1,2,3};
         Integer[] publicacionesFav = new Integer[] {1,2,3};
         Integer[] compra = new Integer[] {1,2,3};

         UsuarioDTO usuarioDTO = new UsuarioDTO("Anderson", "Peña", "Calle 50",
                 "3193150066", Arrays.asList(comentarios), Arrays.asList(publicaciones),
                 Arrays.asList(publicacionesFav), Arrays.asList(compra), "anderson@gmail.com",
                 "contrasena");

         int codigo = usuarioServicio.crearUsuario(usuarioDTO);

         Usuario usuario = usuarioServicio.obtenerUsuario(codigo);

         Assertions.assertEquals("Anderson", usuario.getNombre());

 }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() throws Exception {

         usuarioServicio.eliminiarUsuario(1);

         Assertions.assertNull(usuarioRepo.findById(1).orElse(null));

 }

@Test
@Sql("classpath:dataset.sql")
 public void actualizar() throws Exception {

    Usuario usuario = usuarioServicio.obtenerUsuario(1);

    UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre(), usuario.getApellido(),
            "calle 20", usuario.getTelefono(), null, null, null,
            null, usuario.getEmail(), usuario.getPassword());

    int codigo = usuarioServicio.actualizarUsuario(1,usuarioDTO);

    Usuario actualizado = usuarioServicio.obtenerUsuario(codigo);

    Assertions.assertEquals("calle 20", actualizado.getDireccion());

 }

 @Test
 @Sql("classpath:dataset.sql")
 public void obtener() throws Exception {

     Usuario usuario = usuarioServicio.obtenerUsuario(1);

     Assertions.assertNotNull(usuario);

 }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Usuario> list = usuarioRepo.findAll();
        System.out.println(list);

    }

}
