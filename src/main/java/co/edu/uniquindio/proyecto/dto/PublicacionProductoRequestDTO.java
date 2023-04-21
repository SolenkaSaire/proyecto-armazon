package co.edu.uniquindio.proyecto.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicacionProductoRequestDTO {
    private PublicacionProductoDTO publicacionProductoDTO;
    private ProductoDTO productoDTO;

    public PublicacionProductoRequestDTO(PublicacionProductoDTO publicacionProductoDTO, ProductoDTO productoDTO) {
        this.publicacionProductoDTO = publicacionProductoDTO;
        this.productoDTO = productoDTO;
    }

    // getters y setters
}

