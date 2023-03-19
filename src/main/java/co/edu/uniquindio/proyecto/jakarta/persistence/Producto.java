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
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50)
    private Estado estado;

    @Column(nullable = false, length = 50)
    private String nombre;


    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Categoria> categoria;

    @OneToMany
    @Column(nullable = false, length = 50)
    private List<Ciudad> ciudad;

    @OneToMany
    @Column(nullable = false, length = 50)
    private List<Imagen> imagenes;



}

