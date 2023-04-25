package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
public class CloudinaryServicioImpl implements CloudinaryServicio {
    private Cloudinary cloudinary;
    PublicacionProductoServicio publicacionProductoServicio;
    PublicacionProductoRepo publicacionProductoRepo;
    private Map<String, String> config;
    //public CloudinaryServicio(){
    public CloudinaryServicioImpl(){
        // Configure
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

    }
    @Override
    public Map subirImagen(File file, String carpeta, int codigoPublicacion) throws Exception{
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

        Map<String, Object> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "folder", "co/edu/uniquindio/proyecto",
                "use_filename", true,
                "unique_filename", false));

        System.out.println(uploadResult.toString());
        String rutaRaw = uploadResult.toString();
        ////////////////
        /*
        String cadena = uploadResult.toString();
        int inicio = cadena.indexOf("http://res.cloudinary.com/dwkkkwnpr/image/upload/v1682389379/");
        int fin = cadena.lastIndexOf(".jpg,");
        String subcadena = cadena.substring(inicio, fin);
        System.out.println(subcadena);
        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(codigoPublicacion);
        publicacionProducto.getProducto().getImagenes().add(subcadena);
        publicacionProductoRepo.save(publicacionProducto);
        */
        String urlRegex = "https://res\\.cloudinary\\.com/dwkkkwnpr/image/upload/v\\d+/[a-zA-Z]+/[a-zA-Z]+/[a-zA-Z]+\\.jpg";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(rutaRaw);
        String rutaNew;
        if (matcher.find()) {
            rutaNew= matcher.group(0);
            System.out.println("esta la nueva ruta: "+rutaNew);
            PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(codigoPublicacion);
            publicacionProducto.getProducto().getImagenes().add(rutaNew);
            publicacionProductoRepo.save(publicacionProducto);
        } else {
            rutaNew= null;
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


        //return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
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
