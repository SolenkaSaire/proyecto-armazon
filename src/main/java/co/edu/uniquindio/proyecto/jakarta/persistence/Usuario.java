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
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private int cedula;

    @Column(nullable = false)
    private String nombre;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    private String telefono;
    private String direccion;
    private String contraseña;


}
