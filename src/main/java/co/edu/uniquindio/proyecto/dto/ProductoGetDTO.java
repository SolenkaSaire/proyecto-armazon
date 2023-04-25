package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {
    private String nombre;
    private List<String> categorias;
    private List<String> imagenes;
    private List<Integer> codigoPublicacionProductos;
    private List<String> ciudades;


}