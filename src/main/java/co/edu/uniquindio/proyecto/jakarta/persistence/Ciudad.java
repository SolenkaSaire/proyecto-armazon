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
public class Ciudad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 50)
    private int codigo;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
}
