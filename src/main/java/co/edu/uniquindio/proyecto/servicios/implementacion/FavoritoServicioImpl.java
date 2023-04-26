package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoritoServicioImpl implements FavoritoServicio {

    private UsuarioRepo usuarioRepo;
    private PublicacionProductoRepo publicacionProductoRepo;

    @Override
    public int agregarPublicacionFavorita(int idUsuario, int idPublicacion) {
        Usuario usuario = usuarioRepo.findById(idUsuario)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un usuario con el id " + idUsuario));
        PublicacionProducto publicacion = publicacionProductoRepo.findById(idPublicacion)
                .orElseThrow(() -> new NoSuchElementException("No se encontró una publicación con el id " + idPublicacion));
        List<PublicacionProducto> publicacionesFavoritas = usuario.getPublicacionesFavoritas();
        if (publicacionesFavoritas.contains(publicacion)) {
            throw new IllegalStateException("La publicación ya está en la lista de favoritos del usuario");
        }
        publicacionesFavoritas.add(publicacion);
        usuarioRepo.save(usuario);

        return usuario.getCodigo();

    }

    @Override
    public int eliminarPublicacionFavorita(int idUsuario, int idPublicacion) {
        Usuario usuario = usuarioRepo.findById(idUsuario)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un usuario con el id " + idUsuario));
        PublicacionProducto publicacion = publicacionProductoRepo.findById(idPublicacion)
                .orElseThrow(() -> new NoSuchElementException("No se encontró una publicación con el id " + idPublicacion));
        List<PublicacionProducto> publicacionesFavoritas = usuario.getPublicacionesFavoritas();
        if (!publicacionesFavoritas.contains(publicacion)) {
            throw new IllegalStateException("La publicación no está en la lista de favoritos del usuario");
        }
        publicacionesFavoritas.remove(publicacion);
        usuarioRepo.save(usuario);

        return usuario.getCodigo();

    }

}
