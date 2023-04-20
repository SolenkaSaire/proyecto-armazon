package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PublicacionProductoDTO {

    @NotBlank
    @NotNull
    private double promedioEstrellas;

    @NotBlank
    @NotNull
    private LocalDateTime fechaLimite;

    @NotBlank
    @NotNull
    private double precio;

    @NotBlank
    @NotNull
    private int disponibilidad;

    @NotBlank
    @NotNull
    @Length(max=100, message = "descripcion maximo 100 caracteres")
    private String descripcion;
    public int codigoVendedor;
    private int codigoProducto;

}
