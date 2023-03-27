package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
}
