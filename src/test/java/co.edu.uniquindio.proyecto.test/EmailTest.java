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

        String email= "<h1>Este es un mensaje de prueba</h1><p>¡Gracias por utilizar Spring Mail!</p><p>Movelo pues</p><img src='https://www.uniquindio.edu.co/info/uniquindio/media/bloque2477.png' width='400' height='200'>";
        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
                    email,
                "cristian.gon1414@gmail.com"));

    }



}
