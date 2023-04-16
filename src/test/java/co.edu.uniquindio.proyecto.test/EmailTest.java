package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarCorreoTest() throws Exception{
        emailServicio.enviarEmail(new EmailDTO(
                "perro",
                "hola como vas",
                "cristian.gon1414@gmail.com"));

    }

}
