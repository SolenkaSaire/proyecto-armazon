package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.ProductoModeradorDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoDTO;
import co.edu.uniquindio.proyecto.dto.PublicacionProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio{
    private final ModeradorRepo moderadorRepo;
    private final ProductoModeradorRepo productoModeradorRepo;

    private final PublicacionProductoRepo publicacionProductoRepo;
    private final EmailServicio emailServicio;
    private final PublicacionProductoServicio publicacionProductoServicio;


    @Override
    public int autorizarPublicacion(ProductoModeradorDTO productoModeradorDTO) throws Exception{

        LocalDateTime fechaActual = LocalDateTime.now();
        PublicacionProducto publicacionProducto = publicacionProductoServicio.obtenerPublicacionProductoP(productoModeradorDTO.getCodigoPublicacion());
        publicacionProducto.setEstado(productoModeradorDTO.getEstado());

        publicacionProductoRepo.save(publicacionProducto);

        ProductoModerador productoModerador = new ProductoModerador();

        productoModerador.setFecha(fechaActual);
        productoModerador.setMotivo(productoModeradorDTO.getMotivo());
        productoModerador.setEstado(productoModeradorDTO.getEstado());
        productoModerador.setPublicacionProducto(publicacionProducto);
        productoModerador.setModerador(obtenerModerador(productoModeradorDTO.getIdModerador()));

        String emailAprobado= "<h1>¡¡¡En horabuena!!!  Tu producto ha sido aprobado</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'> <br>El motivo es "+ productoModerador.getMotivo() + "<br>Fecha de Aprobacion:" +fechaActual;
        String emailDesaprobado= "<h1>¡¡¡Que mal!!!  Tu producto ha sido rechazado...</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'> <br>El motivo es: " + productoModerador.getMotivo() + "<br>Fecha de Negacion:"+fechaActual;

        if(productoModeradorDTO.getEstado().equals(Estado.APROBADO)){
            emailServicio.enviarEmail(new EmailDTO(
                    "Actualizacion en su Publicacion - Autorizacion",
                    emailAprobado,
                    publicacionProducto.getVendedor().getEmail()));
        }else if(productoModeradorDTO.getEstado().equals(Estado.NO_APROBADO)){
            emailServicio.enviarEmail(new EmailDTO(
                    "Actualizacion en su Publicacion - Autorizacion",
                    emailDesaprobado,
                    publicacionProducto.getVendedor().getEmail()));
        }


        return productoModeradorRepo.save(productoModerador).getCodigo_estado();

    }

    @Override
    public Moderador obtenerModerador(int codigoModerador) throws Exception {

        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if (moderador.isEmpty()) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún moderador");
        }

        return moderador.get();

    }
}
