package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {
    private String texto;

    private int estrellas;

    private int codigoUsuario;

    private int codigoPublicacionProducto;


}