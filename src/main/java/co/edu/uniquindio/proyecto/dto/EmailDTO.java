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
public class EmailDTO {

    @NotBlank
    @NotNull
    @Length(max=100, message = "asunto maximo 100 caracteres")
    private String asunto;

    @NotBlank
    @NotNull
    @Length(max=500, message = "cuerpo maximo 500 caracteres")
    private String cuerpo ="text/html; charset=utf-8";

    @NotBlank
    @NotNull
    @Length(max=100, message = "destinatario maximo 100 caracteres")
    private String destinatario;

}