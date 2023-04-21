package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SpringBootTest
@Transactional
public class CloudinaryTest {
    @Autowired
    private CloudinaryServicio cloudinaryServicio;


    @Test
    public void subirImagenTest() throws Exception{

        File file = new File("C:\\Users\\Cristian\\Pictures\\Saved Pictures\\prueba.jpg");

      //  cloudinaryServicio.subirImagen(file,"Articulos");
    }
    @Test
    public void eliminarImagenTest() throws Exception{
        File file = new File("C:\\Users\\Cristian\\Pictures\\Saved Pictures\\prueba.jpg");
      //  cloudinary.uploader().upload(file, ObjectUtils.asMap("Articulos","Articulos"));


    }








}
