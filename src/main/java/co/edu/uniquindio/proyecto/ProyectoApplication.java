package co.edu.uniquindio.proyecto;
import co.edu.uniquindio.proyecto.modelo.Cuenta;
import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProyectoApplication.class, args);

    }
}