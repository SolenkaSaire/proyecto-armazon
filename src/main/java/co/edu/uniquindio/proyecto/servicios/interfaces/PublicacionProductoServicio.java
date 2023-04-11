package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.Ciudad;

import java.util.List;

public interface PublicacionProductoServicio {


    List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades);
}
