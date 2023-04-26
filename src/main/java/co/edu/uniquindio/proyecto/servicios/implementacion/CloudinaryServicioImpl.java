package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class CloudinaryServicioImpl implements CloudinaryServicio {

    private final PublicacionProductoServicio publicacionProductoServicio;

    private final ProductoRepo productoRepo;

    private Map<String, String> config;

    @Override
    public Map subirImagen(File file, String carpeta, int codigoPublicacion) throws Exception{


        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

        Map<String, Object> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "folder", "co/edu/uniquindio/proyecto",
                "use_filename", true,
                "unique_filename", false));

        String rutaRaw = uploadResult.toString();

        Pattern pattern = Pattern.compile("https://res.cloudinary.com/.+?\\.jpg");
        Matcher matcher = pattern.matcher(rutaRaw);

        if (matcher.find()) {
            String imageURL = matcher.group();
            System.out.println("la ruta es: "+imageURL);
            PublicacionProducto publicacionProducto = new PublicacionProducto();
            publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(codigoPublicacion);
            Producto producto = publicacionProducto.getProducto();
            if (publicacionProducto.getCodigo() == codigoPublicacion) {
                System.out.println("el codigo es el mismo, procede a guardar img");
                producto.getImagenes().add(imageURL);
                productoRepo.save(producto);

             }


        }
        return uploadResult;
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception{
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

        String publicId= "imagenes/Captura_de_pantalla_4_.png11414006616483813673";

        Map<String, Object> deleteResult = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        System.out.println(deleteResult.toString());

        return deleteResult;
    }
    @Override
    public File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
