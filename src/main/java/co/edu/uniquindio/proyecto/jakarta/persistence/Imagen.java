package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Imagen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 50)
    private int id_imagen;

    @Column(nullable = false, length = 50)
    private String ruta_URL;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    
    /////////////////7
}
