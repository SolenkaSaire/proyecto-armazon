package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {

    @Query("select m from Moderador m where m.email = :correo")
    Moderador buscarModerador(String correo);

    @Query("select m.codigo, m.email from Moderador m where m.codigo =:codigo")
    Object[] obtenerDatosModerador(String codigo);




}
