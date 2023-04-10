package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = ?1")
    Usuario obtener(String email);
    Usuario findByEmail(String email);

    @Query("select u from Usuario u where u.email = :email and u.password = :password")
    Usuario comprobarAutenticacion(String email, String password);

    @Query("select u from Usuario u where u.email = :email")
    Usuario buscarUsuario(String email);
    @Query("select u.nombre, u.email from Usuario u where u.codigo =:codigo")
    Object[] obtenerDatosUsuario(String codigo);


   // Usuario findByEmailAndPassword();

}
