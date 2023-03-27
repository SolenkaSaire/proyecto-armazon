 package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.jakarta.persistence.Cuenta;
import co.edu.uniquindio.proyecto.jakarta.persistence.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE )
public class UsuarioTest {
 @Autowired
 private UsuarioRepo usuarioRepo;

 @Test
 public void registar(){

     String[] tels = new String[] {"354515", "46846"};
   Cuenta cuenta2= new Cuenta ( 1, "mi.email@email.com", "mipassword");
  Usuario usuario = new Usuario( cuenta2, 1,"sol","mary","calle**", "30059",null, null, null);



    Usuario guardado = usuarioRepo.save(usuario);

    Assertions.assertNotNull(guardado);
 }

 public void eleminar(){

    //  String[] tels = new String[] {"354515", "46846"};
      Cuenta cuenta1= new Cuenta ( 1, "mi.email@email.com", "mipassword");
    Usuario usuario = new Usuario( cuenta1, 1,"sol","mary","calle**", "30059", null, null, null);
    usuario.setCedula(1);
    Usuario guardado = usuarioRepo.save(usuario);

    Assertions.assertNotNull(guardado);


 }


    @Id
    private Long id;


}
