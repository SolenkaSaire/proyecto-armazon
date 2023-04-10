package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PublicacionProductoDTO {
   // codigo;fecha_publicacion;promedioEstrellas;fechaCreacion;fechaLimite;precio;disponibilidad;descripcion;

    @NotBlank
    @NotNull
    private int codigo;
   // private LocalDateTime fecha_publicacion;

    @NotBlank
    @NotNull
    private double promedioEstrellas;

  //  private LocalDateTime fechaCreacion;

    @NotBlank
    @NotNull
    private LocalDateTime fechaLimite;

    @NotBlank
    @NotNull
    private double precio;

    @NotBlank
    @NotNull
    private int disponibilidad;

    @NotBlank
    @NotNull
    @Length(max=100, message = "descripcion maximo 100 caracteres")
    private String descripcion;

    private Estado estado;
    public List<Integer> codigosCiudades;
    public int codigoVendedor;
    public int codigoProducto;
}
