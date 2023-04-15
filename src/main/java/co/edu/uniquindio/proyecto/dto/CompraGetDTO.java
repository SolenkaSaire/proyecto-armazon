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

    private double total;

    private MetodoPago metodoPago;

    private int codigoUsuario;

    private List<DetalleCompra> detalleCompra;

}