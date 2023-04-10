package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {
//private String nombre;    private List<Categoria> categoria;    private List<String> imagenes;    private List<PublicacionProducto> publicacionProductos;

    @NotBlank
    @NotNull
    @Length(max=50, message = "nombre maximo 50 caracteres")
    private String nombre;
    private List<String> categoria;
    @NotBlank
    @NotNull
    @Length(max=100, message = "descripcion maximo 100 caracteres")
    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    private List<String> imagenes;

    private List<Categoria> categorias;

}