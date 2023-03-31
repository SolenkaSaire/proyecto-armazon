package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.jakarta.persistence.DetalleCompra;
import co.edu.uniquindio.proyecto.jakarta.persistence.MetodoPago;

import java.time.LocalDateTime;
import java.util.List;

public class DetalleCompraGetDTO {

    private LocalDateTime fecha;

    private float valorTotal;

    private MetodoPago metodoPago;

    private List<DetalleCompraDTO> detalleCompraDTO;

}
