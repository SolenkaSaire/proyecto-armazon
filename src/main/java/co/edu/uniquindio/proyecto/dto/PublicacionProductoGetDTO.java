package co.edu.uniquindio.proyecto.dto;


import co.edu.uniquindio.proyecto.jakarta.persistence.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class PublicacionProductoGetDTO {
    private int codigo;
    private LocalDateTime fecha_publicacion;
    private double promedioEstrellas;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaLimite;
    private double precio;
    private int disponibilidad;
    private String descripcion;
    public Usuario vendedor;

}
