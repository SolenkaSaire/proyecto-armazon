package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
public class PublicacionProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fecha_publicacion;

    @Column(nullable = true)
    private Double promedioEstrellas;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Positive
    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int disponibilidad;

    @Column(nullable = false)
    private String descripcion;


    @ManyToOne
    private Usuario vendedor;
//codigo;fecha_publicacion;promedioEstrellas;fechaCreacion;fechaLimite;precio;disponibilidad;descripcion, Usuario, vendedor
//  List<Usuario> favoritos;List<ProductoModerador> moderadores;List<DetalleCompra> compras;  List<Comentario> comentarios;
    //Estado estado; List<Ciudad> ciudades;

    @ManyToMany(mappedBy = "publicacionesFavoritas")
    private List<Usuario> favoritos;
    @OneToMany(mappedBy = "publicacionProducto")
    private List<ProductoModerador> moderadores;
    @OneToMany(mappedBy = "publicacionProducto")
    private List<DetalleCompra> compras;
    @OneToMany(mappedBy = "publicacionProducto")
    private List<Comentario> comentarios;
    @ManyToOne
    private Producto producto;
    @Column(nullable = false)
    private Estado estado;

}
