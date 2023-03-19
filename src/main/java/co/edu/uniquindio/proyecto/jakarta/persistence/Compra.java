package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private int codigo;


    private Double total;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = false, length = 50)
    private LocalDateTime fecha_creacion;

    @ManyToMany(mappedBy = "publicacionProductos")
    private List<PublicacionProducto> publicacionProductos;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

}
