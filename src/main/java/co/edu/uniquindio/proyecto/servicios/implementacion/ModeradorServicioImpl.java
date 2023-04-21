package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.ProductoModeradorDTO;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio{
    private  final PublicacionProductoRepo publicacionProductoRepo;
    private final ModeradorRepo moderadorRepo;
    private final ProductoModeradorRepo productoModeradorRepo;
    private final EmailServicio emailServicio;
    //cambios
    //private final PublicacionProductoServicio publicacionProductoServicio;
    @Override
    public int aprobarProducto(PublicacionProducto publicacionProducto, ProductoModeradorDTO productoModeradorDTO) throws Exception{

        LocalDateTime fechaActual = LocalDateTime.now();

        publicacionProducto.setEstado(Estado.APROBADO);

        ProductoModerador productoModerador = new ProductoModerador();

        productoModerador.setFecha(fechaActual);
        productoModerador.setMotivo(productoModeradorDTO.getMotivo());
        productoModerador.setEstado(Estado.APROBADO);
        productoModerador.setPublicacionProducto(publicacionProducto);
        productoModerador.setModerador(obtenerModerador(productoModeradorDTO.getIdModerador()));

        String email= "<h1>¡¡¡En horabuena!!!  Tu producto a sido aprobado</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'>";

        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
                email,
                publicacionProducto.getVendedor().getEmail()));

        return productoModeradorRepo.save(productoModerador).getCodigo_estado();

    }

    @Override
    public int rechazarProducto(PublicacionProducto publicacionProducto, ProductoModeradorDTO productoModeradorDTO) throws Exception {

        LocalDateTime fechaActual = LocalDateTime.now();

        publicacionProducto.setEstado(Estado.NO_APROBADO);

        ProductoModerador productoModerador = new ProductoModerador();

        productoModerador.setFecha(fechaActual);
        productoModerador.setMotivo(productoModeradorDTO.getMotivo());
        productoModerador.setEstado(Estado.NO_APROBADO);
        productoModerador.setPublicacionProducto(publicacionProducto);
        productoModerador.setModerador(obtenerModerador(productoModeradorDTO.getIdModerador()));

        String email= "<h1>¡¡¡Que mal!!!  Tu producto a sido rechazado...</h1><h2><p>En tu cuenta de Armazon</p></h2><img src='https://i.ibb.co/mHSHGmn/Imagen-de-Whats-App-2023-04-21-a-las-11-31-00.jpg' width='300' height='200'>";

        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
                email,
                publicacionProducto.getVendedor().getEmail()));

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
