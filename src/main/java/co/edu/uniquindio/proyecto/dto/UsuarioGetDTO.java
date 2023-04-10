package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    //private int codigo;

    private String nombre;
    private String apellido;


    private String email;

    private String direccion;

    private String telefono;

}
