package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.ManyToMany;



@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 10)
    private String email;

    @Column(nullable = false,length = 30)
    private String password;



}