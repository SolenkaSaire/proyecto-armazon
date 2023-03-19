package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50)
    private int unidades;

    @Column(nullable = false, length = 50)
    private double precio;
}
