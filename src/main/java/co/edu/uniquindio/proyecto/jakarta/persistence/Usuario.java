package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private int cedula;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false,length = 50)
    private String apellido;

    @Column(nullable = false,length = 50)
    private String direccion;

    @Column(length = 10)
    private String telefono;

    @ManyToMany
    @JoinTable(name = "comentario",
            joinColumns = @JoinColumn(name = "cedula_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_publicacion")
    )
    private List<PublicacionProducto> publicacionProductos;



    @ManyToMany(mappedBy = "favoritos")
    private List<PublicacionProducto> favoritos;
}