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
    //codigo;nombre;categoria;imagenes;publicacionProductos;
    private int codigo;

    private String nombre;

    private List<String> imagenes;

    private List<Categoria> categorias;
    private List<PublicacionProducto> publicacionProductos;

}