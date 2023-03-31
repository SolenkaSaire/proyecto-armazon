package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.jakarta.persistence.Ciudad;
import co.edu.uniquindio.proyecto.jakarta.persistence.Estado;
import co.edu.uniquindio.proyecto.jakarta.persistence.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PublicacionProductoDTO {
   // codigo;fecha_publicacion;promedioEstrellas;fechaCreacion;fechaLimite;precio;disponibilidad;descripcion;

    private LocalDateTime fecha_publicacion;
    private double promedioEstrellas;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaLimite;
    private double precio;
    private int disponibilidad;
    private String descripcion;
    private Estado estado;
    public List<Ciudad> Ciudad;
    public Usuario vendedor;
}
