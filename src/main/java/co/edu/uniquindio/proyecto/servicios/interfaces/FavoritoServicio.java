package co.edu.uniquindio.proyecto.servicios.interfaces;

public interface FavoritoServicio {

    int agregarPublicacionFavorita(int idUsuario, int idPublicacion);

    int eliminarPublicacionFavorita(int idUsuario, int idPublicacion);

}
