package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoModerador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo_estado;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 50)
    private String motivo;

    private Estado estado;


    @ManyToOne
    private PublicacionProducto publicacionProducto;

    @ManyToOne
    private Moderador moderador;

}
