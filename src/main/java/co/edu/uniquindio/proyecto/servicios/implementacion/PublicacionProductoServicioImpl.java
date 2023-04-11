package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.Ciudad;
import co.edu.uniquindio.proyecto.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicacionProductoServicioImpl implements PublicacionProductoServicio {

    @Override
    public List<Integer> obtenerCiudadesCodigo(List<Ciudad> ciudades) {
        List<Integer> codigosCiudades = new ArrayList<>();
        for (Ciudad c: ciudades) {
            codigosCiudades.add( c.getCodigo() );

        }
        return codigosCiudades;
    }
}
