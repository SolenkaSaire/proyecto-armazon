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
public class Comentario implements Serializable {
    //////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = true, length = 70)
    private String texto;

    @Column(nullable = false, length = 50)
    private int estrellas;

    @Column(nullable = false, length = 50)
    private LocalDateTime fecha_creacion;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private PublicacionProducto publicacionProducto;


}
