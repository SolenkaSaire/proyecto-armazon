 package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

     /*
 @Autowired
 private UsuarioRepo usuarioRepo;*/
 @Autowired
 private UsuarioServicio usuarioServicio;


     @Test
    public void registar() throws Exception {

    LocalDateTime fechaActual = LocalDateTime.now();
    UsuarioDTO u = new UsuarioDTO(
       //     1,
            "cri",
            "gonza",
            "crist@gmail.com",
            "contra123",
            "micasita",
            "3104034332"
    );

     int guardado = usuarioServicio.crearUsuario(u);
     //Assertions.assertNotNull("cris", guardado.getNombre());
     Assertions.assertEquals(1,guardado);
/*
    Usuario user= new Usuario();
    user.setCodigo(12345);
    user.setPassword("123");
    user.setEmail("1264");
    user.setNombre("cris");
    user.setApellido("gonza");
    user.setDireccion("calle16");
    user.setTelefono("12345");
    user.setComentario(null);
    user.setMisProductos(null);
    user.setPublicacionesFavoritas(null);
    user.setCompra(null);

   //  Comentario comentario = new Comentario(125,"hola",12,fechaActual,usuarioPrueba,null);
     //PRUEBA USUARIO VACIO
    // Usuario usuarioPrueba2 = new Usuario();


     Usuario guardado = usuarioRepo.save(user);
     //Assertions.assertNotNull("cris", guardado.getNombre());
     Assertions.assertEquals("cris",guardado.getNombre());
    */

 }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTest() throws Exception {

         Usuario usuario = usuarioServicio.obtenerUsuario(1);

    }

/*
 @Test
 public void eliminar(){

     LocalDateTime fechaActual = LocalDateTime.now();


     Usuario user= new Usuario();
     user.setCodigo(1);
     user.setPassword("123");
     user.setEmail("1264");
     user.setNombre("cris");
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setTelefono("12345");
     user.setComentario(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setCompra(null);

     Usuario guardado = usuarioRepo.save(user);
     usuarioRepo.delete(guardado);
     Optional<Usuario> buscado= usuarioRepo.findById(1);

    Assertions.assertNull(buscado.orElse(null));
 }

@Test
 public void actualizar(){
     LocalDateTime fechaActual = LocalDateTime.now();

     Usuario user= new Usuario();
     user.setCodigo(1);
     user.setPassword("123");
     user.setEmail("1264");
     user.setNombre("cris");
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setTelefono("12345");
     user.setComentario(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setCompra(null);

     Usuario guardado = usuarioRepo.save(user);

     guardado.setEmail("sole");

     Usuario nuevo = usuarioRepo.save(guardado);

     Assertions.assertEquals("sole", nuevo.getEmail());
 }

 @Test
 public void obtener(){

     LocalDateTime fechaActual = LocalDateTime.now();

     Usuario user= new Usuario();
     user.setCodigo(1);
     user.setPassword("123");
     user.setEmail("1264");
     user.setNombre("cris");
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setTelefono("12345");
     user.setComentario(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setCompra(null);

     Usuario guardado = usuarioRepo.save(user);
     System.out.println(guardado);

     Optional<Usuario> buscado = usuarioRepo.findById(6);
     System.out.println(buscado.orElse(null));


 }

 @Test
 @Sql("classpath:dataset.sql")
 public void listar(){

     List<Usuario> lista =usuarioRepo.findAll();

     lista.forEach(System.out::println);

 }*/


}
