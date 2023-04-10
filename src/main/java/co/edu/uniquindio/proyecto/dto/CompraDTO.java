package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    @NotBlank
    @NotNull
    private double total;

    @NotBlank
    @NotNull
    private int codigoUsuario;

    @NotBlank
    @NotNull
    private MetodoPago metodoPago;

    @NotBlank
    @NotNull
    private List<DetalleCompraDTO> detalleCompraDTO;
}