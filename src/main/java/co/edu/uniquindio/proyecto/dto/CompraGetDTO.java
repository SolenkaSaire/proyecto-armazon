package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.jakarta.persistence.MetodoPago;
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

    private float valorTotal;

    private int codigoUsuario;

    private MetodoPago metodoPago;

    private List<DetalleCompraDTO> detalleCompraDTO;

}