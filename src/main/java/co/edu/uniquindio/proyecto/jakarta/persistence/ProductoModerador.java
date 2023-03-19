package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoModerador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo_estado;

    @Column(nullable = false, length = 50)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 50)
    private String motivo;

/*
    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;
*/
}
