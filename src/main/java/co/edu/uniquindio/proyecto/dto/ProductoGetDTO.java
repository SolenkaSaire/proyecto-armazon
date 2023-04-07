package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.jakarta.persistence.Categoria;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.PublicacionProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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