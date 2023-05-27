package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;
@ToString
@AllArgsConstructor
@Getter
@Setter
public class PublicacionProductoDTO {


    @NotNull
    private double promedioEstrellas;

    @NotBlank
    @NotNull
    private LocalDateTime fechaLimite;

    private double precio;


    @NotNull
    private int disponibilidad;

    @NotBlank
    @NotNull
    @Length(max=100, message = "descripcion maximo 100 caracteres")
    private String descripcion;
    public int codigoVendedor;
    private int codigoProducto;

    private ProductoDTO productoDTO;

    private List<ComentarioDTO> comentarioDTO;


}
