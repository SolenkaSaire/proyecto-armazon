package co.edu.uniquindio.proyecto.jakarta.persistence;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany
    @JoinTable(name = "comentarios",
            joinColumns = @JoinColumn(name = "cedula_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_publicacion")
    )
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "favoritos")
    private List<Usuario> favoritos;

    @ManyToMany(mappedBy = "moderadores")
    private List<Moderador> moderadores;


    @ManyToMany
    @JoinTable(name = "detalle_compra",
                    joinColumns = @JoinColumn(name = "codigo_compra"),
                    inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private List<Compra> compras;

    @ManyToOne
    private Producto producto;

    ///////////////////






}
