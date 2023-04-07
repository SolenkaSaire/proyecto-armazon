 package co.edu.uniquindio.proyecto.test;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.uniquindio.proyecto.jakarta.persistence.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


 @DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE )
public class UsuarioTest {
 @Autowired
 private UsuarioRepo usuarioRepo;

 @Test
 public void registar(){

    LocalDateTime fechaActual = LocalDateTime.now();

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
 }

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

 }


}
