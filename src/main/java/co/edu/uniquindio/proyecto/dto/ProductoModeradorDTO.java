package co.edu.uniquindio.proyecto.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductoModeradorDTO {

    @NotBlank
    @NotNull
    @Column(nullable = false, length = 50)
    private String motivo;

    @NotBlank
    @NotNull
    private int idModerador;

}
