package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalleCompraDTO {

    @NotBlank
    @NotNull
    private int unidades;

    @NotBlank
    @NotNull
    private double precio;


    @NotBlank
    @NotNull
    private int codigoPublicacionProducto;


    @NotBlank
    @NotNull
    private int codigoProducto;
}
