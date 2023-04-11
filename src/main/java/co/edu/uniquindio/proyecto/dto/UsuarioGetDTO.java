package co.edu.uniquindio.proyecto.dto;

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
@ToString
public class UsuarioGetDTO {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private List<String> comentarios;
    private List<Integer> codigoMisPublicaciones;
    private List<Integer> codigoPublicacionesFavoritas;
    private List<Integer> codigoCompra;
    private String email;
    private String password;
}
