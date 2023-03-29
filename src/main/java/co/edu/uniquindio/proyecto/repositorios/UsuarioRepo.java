package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = ?1")
    Usuario obtener(String email);
    Usuario findByCorreo(String email);

    @Query("select u from Usuario u where u.email = :email and u.password = :password")
    Usuario comprobarAutenticacion(String email, String password);

    Usuario findByEmailAndPassword();

    Usuario buscarUsuario(String email);
}
