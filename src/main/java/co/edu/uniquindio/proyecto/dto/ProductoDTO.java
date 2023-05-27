package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Ciudad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {
//private String nombre;    private List<Categoria> categoria;    private List<String> imagenes;    private List<PublicacionProducto> publicacionProductos;

    @NotBlank
    @NotNull
    @Length(max=50, message = "nombre maximo 50 caracteres")
    private String nombre;

    @NotBlank
    @NotNull
    private List<Categoria> categorias;
    @NotBlank
    @NotNull
    @Length(max=50, message = "imagenes maximo 50 caracteres")
    private List<String> imagenes;

    @NotBlank
    @NotNull
    private List<Ciudad> ciudades;
}