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
public class ComentarioDTO {

    @NotBlank
    @NotNull
    @Length(max=70, message = "mensaje maximo 70 caracteres")
    private String texto;

    private int estrellas;

    @NotBlank
    @NotNull
    @Length(max=50, message = "codigo maximo 50 caracteres")
    private int codigoUsuario;

    @NotBlank
    @NotNull
    @Length(max=50, message = "nombre maximo 50 caracteres")
    private int codigoPublicacionProducto;

}