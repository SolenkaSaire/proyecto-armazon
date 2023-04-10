package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {


    private int codigo;

    private LocalDateTime fecha;

    private double total;

    private int codigoUsuario;

    private MetodoPago metodoPago;

    private List<DetalleCompra> detalleCompra;

}