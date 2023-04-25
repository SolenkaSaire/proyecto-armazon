package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Categoria> categoria;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Ciudad> ciudad;


    @ElementCollection
    @Column(nullable = false)
    //@JoinColumn(name = "ruta_imagen")
    private List<String> imagenes;

    @OneToMany(mappedBy="producto")
    private List<PublicacionProducto> publicacionProductos;



//////////////////////////codigo;nombre;categoria;imagenes;publicacionProductos;

}

