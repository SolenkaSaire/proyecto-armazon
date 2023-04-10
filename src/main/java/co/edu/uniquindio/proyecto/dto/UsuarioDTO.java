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
public class UsuarioDTO {

    //private int codigo;
    @NotBlank
    @NotNull
    @Length(max=100, message = "nombre maximo 100 caracteres")
    private String nombre;
    @NotBlank
    @NotNull
    @Length(max=100, message = "apellido maximo 100 caracteres")
    private String apellido;
    @NotBlank
    @NotNull
    @Length(max=100, message = "email maximo 150 caracteres")
    private String email;
    @NotBlank
    @NotNull
    @Length(max=150, message = "password maximo 100 caracteres")
    private String password;
    @NotBlank
    @NotNull
    @Length(max=50, message = "direccion maximo 50 caracteres")
    private String direccion;
    @NotBlank
    @NotNull
    @Length(max=10, message = "telefono maximo 20 caracteres")
    private String telefono;
}