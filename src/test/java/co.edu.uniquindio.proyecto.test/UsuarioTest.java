 package co.edu.uniquindio.proyecto.test;

import ch.qos.logback.core.CoreConstants;
import co.edu.uniquindio.proyecto.jakarta.persistence.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
    user.setPassword("123");
    user.setEmail("1264");
    user.setCompra(null);
    user.setApellido("gonza");
    user.setDireccion("calle16");
    user.setNombre("cris");
    user.setCompra(null);
    user.setMisProductos(null);
    user.setPublicacionesFavoritas(null);
    user.setTelefono("12345");
    user.setCodigo(12345);

   //  Comentario comentario = new Comentario(125,"hola",12,fechaActual,usuarioPrueba,null);
     //PRUEBA USUARIO VACIO
    // Usuario usuarioPrueba2 = new Usuario();


     Usuario guardado = usuarioRepo.save(user);
     //Assertions.assertNotNull("cris", guardado.getNombre());
     Assertions.assertEquals("cris",guardado.getNombre());
 }

 @Test
 public void eleminar(){

     LocalDateTime fechaActual = LocalDateTime.now();


     Usuario user= new Usuario();
     user.setPassword("123");
     user.setEmail("1264");
     user.setCompra(null);
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setNombre("cris");
     user.setCompra(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setTelefono("12345");
     user.setCodigo(1);

     Usuario guardado = usuarioRepo.save(user);

     usuarioRepo.delete(guardado);
     Optional<Usuario> buscado= usuarioRepo.findById(1);

    Assertions.assertNull(buscado.orElse(null));
 }

@Test
 public void actualizar(){
     LocalDateTime fechaActual = LocalDateTime.now();
     Usuario user= new Usuario();
     user.setPassword("123");
     user.setEmail("sol");
     user.setCompra(null);
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setNombre("cris");
     user.setCompra(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setTelefono("12345");
     user.setCodigo(1);

     Usuario guardado = usuarioRepo.save(user);

     guardado.setEmail("sole");
     Usuario nuevo = usuarioRepo.save(guardado);
     Assertions.assertEquals("sole", nuevo.getEmail());
 }

 @Test
 public void obtener(){

     LocalDateTime fechaActual = LocalDateTime.now();
     Usuario user= new Usuario();
     user.setPassword("123");
     user.setEmail("sol");
     user.setCompra(null);
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setNombre("cris");
     user.setCompra(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setTelefono("12345");
     user.setCodigo(1);

     Usuario guardado = usuarioRepo.save(user);
     System.out.println(guardado);

     Optional<Usuario> buscado = usuarioRepo.findById(1);
     System.out.println(buscado.orElse(null));


 }

 @Test
 public void listar(){
     LocalDateTime fechaActual = LocalDateTime.now();
     Usuario user= new Usuario();
     user.setPassword("123");
     user.setEmail("sol");
     user.setCompra(null);
     user.setApellido("gonza");
     user.setDireccion("calle16");
     user.setNombre("cris");
     user.setCompra(null);
     user.setMisProductos(null);
     user.setPublicacionesFavoritas(null);
     user.setTelefono("12345");
     user.setCodigo(2);
     usuarioRepo.save(user);

     Usuario user1= new Usuario();
     user1.setPassword("456");
     user1.setEmail("didier");
     user1.setCompra(null);
     user1.setApellido("ortega");
     user1.setDireccion("calle13");
     user1.setNombre("didi");
     user1.setCompra(null);
     user1.setMisProductos(null);
     user1.setPublicacionesFavoritas(null);
     user1.setTelefono("77226");
     user1.setCodigo(1);
     usuarioRepo.save(user1);

     List<Usuario> lista =usuarioRepo.findAll();

     System.out.println(lista);


 }


}
