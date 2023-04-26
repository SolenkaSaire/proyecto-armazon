package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Comentario;
import co.edu.uniquindio.proyecto.modelo.Compra;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
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
    @Length(max=50, message = "direccion maximo 100 caracteres")
    private String direccion;
    @NotBlank
    @NotNull
    @Length(max=10, message = "telefono maximo 12 caracteres")
    private String telefono;

    @NotBlank
    @NotNull(message = "No puede ser null")
    @Email(message = "Error con la estructura del correo")
    @Length(max=100, message = "email maximo 150 caracteres")
    private String email;
    @NotBlank
    @NotNull
    @Length(max=150, message = "password maximo 100 caracteres")
    private String password;

}