package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Moderador;
import co.edu.uniquindio.proyecto.modelo.PublicacionProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ProductoModeradorGetDTO {

    private LocalDateTime fecha;

    private String motivo;

    private Estado estado;

    private PublicacionProducto publicacionProducto;

    private Moderador moderador;

}
