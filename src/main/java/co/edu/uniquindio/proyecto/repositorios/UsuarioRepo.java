package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = ?1")
    Usuario obtener(String email);

    @Query("select u from Usuario u where u.email = :email and u.password = :password")
    Usuario comprobarAutenticacion(String email, String password);

    @Query("select u from Usuario u where u.email = :email")
    Usuario buscarUsuario(String email);
    @Query("select u.nombre, u.email from Usuario u where u.codigo =:codigo")
    Object[] obtenerDatosUsuario(String codigo);

    @Query("select p from Usuario p where p.email = :email")
    Optional<Usuario> findByEmail(String email);


}
