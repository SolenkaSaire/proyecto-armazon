package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class SesionDTO {

    @NotBlank
    @NotNull
    @Length(max=100, message = "email maximo 100 caracteres")
    private String email;

    @NotBlank
    @NotNull
    @Length(max=100, message = "password maximo 100 caracteres")
    private String password;

    private int tipo;

}