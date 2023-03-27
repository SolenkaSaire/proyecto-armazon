package co.edu.uniquindio.proyecto.jakarta.persistence;

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
public class Moderador  extends Cuenta implements Serializable {
    @OneToOne
    private Cuenta cuenta;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    private String codigo;

    @Enumerated(EnumType.STRING)
    @ManyToMany(mappedBy="moderadores")
    private List<Estado> estados;

    @ManyToMany(mappedBy="moderadores")
    private List<PublicacionProducto> publicacionProductos;
////////////////////////7
    /*
    @ManyToMany(mappedBy = "publicacionProductos")
    private List<PublicacionProducto> publicacionProductos;
*/
}