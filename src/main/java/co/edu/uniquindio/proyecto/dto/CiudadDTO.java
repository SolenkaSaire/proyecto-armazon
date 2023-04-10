package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CiudadDTO {

    @NotBlank
    @NotNull
    @Length(max=50, message = "ciudad maximo 50 caracteres")
    String ciudad;

    @NotBlank
    @NotNull
    int codigoPublicacion;
}
