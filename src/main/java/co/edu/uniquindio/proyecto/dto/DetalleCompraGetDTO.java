package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalleCompraGetDTO {

    private int unidades;
    private double precio;
    private int codigoPublicacionProducto;
    private int codigoCompra;

    private double total;

    MetodoPago metodoPago;

    private LocalDateTime fecha;

    private int usuario;

    private String nombreUsuario;


}
