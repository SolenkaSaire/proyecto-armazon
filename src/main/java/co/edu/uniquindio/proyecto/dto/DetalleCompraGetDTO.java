package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import co.edu.uniquindio.proyecto.jakarta.persistence.MetodoPago;
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

    private LocalDateTime fecha;

    private double valorTotal;

    private MetodoPago metodoPago;

    private List<DetalleCompraDTO> detalleCompraDTO;


}
