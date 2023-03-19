package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Array;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Favorito  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 50)
    
    @EqualsAndHashCode.Include
    private int codigo;

}