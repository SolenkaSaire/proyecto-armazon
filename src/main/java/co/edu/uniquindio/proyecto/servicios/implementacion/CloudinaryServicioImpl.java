package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServicioImpl implements CloudinaryServicio {
    private Cloudinary cloudinary;
    private Map<String, String> config;
    //public CloudinaryServicio(){
    public CloudinaryServicioImpl(){
        // Configure
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

    }
    @Override
    public Map subirImagen(File file, String carpeta) throws Exception{
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dwkkkwnpr","api_key", "668466614745114","api_secret", "ROdCofg2ZvIBk1a1zKtsuHRbbhw"));

        Map<String, Object> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "folder", "imagenes",
                "use_filename", true,
                "unique_filename", false));
        System.out.println(uploadResult.toString());

        return uploadResult;

        //return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", String.format("proyecto/%s", carpeta)));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception{
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
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
