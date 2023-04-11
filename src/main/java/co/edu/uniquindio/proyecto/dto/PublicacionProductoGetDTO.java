package co.edu.uniquindio.proyecto.dto;


import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.modelo.Usuario;
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
public class PublicacionProductoGetDTO {
    private double promedioEstrellas;
    private LocalDateTime fechaLimite;
    private double precio;
    private int disponibilidad;
    private String descripcion;
    public int codigoVendedor;
    private List<Integer> codigoUsuarioFavoritos;
    private List<Integer> codigoModeradores;
    private List<Integer> codigoDetalleCompras;
    private List<String> comentarios;
    private int codigoProducto;

    //private Estado estado;
    private String estado;
    public List<Integer> codigosCiudades;

}
