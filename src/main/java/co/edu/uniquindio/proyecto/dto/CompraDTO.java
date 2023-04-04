package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.jakarta.persistence.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private double total;
    private int codigoUsuario;
    private MetodoPago metodoPago;
    private List<DetalleCompraDTO> detalleCompraDTO;
}