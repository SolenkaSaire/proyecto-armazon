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
@AllArgsConstructor
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


    //@ElementCollection
    @Enumerated(value = EnumType.STRING)
    @OneToMany(mappedBy="Producto")
    @Column(nullable = false, length = 50)
    private List<Categoria> categoria;


    @OneToMany(mappedBy="Producto")
    @Column(nullable = false, length = 50)
    private List<Ciudad> ciudad;

    @OneToMany(mappedBy="Producto")
    @Column(nullable = false, length = 50)
    private List<Imagen> imagenes;

    @OneToMany(mappedBy="Producto")
    @Column(nullable = false)
    private List<PublicacionProducto> publicacionProductos;

//////////////////////////

}

