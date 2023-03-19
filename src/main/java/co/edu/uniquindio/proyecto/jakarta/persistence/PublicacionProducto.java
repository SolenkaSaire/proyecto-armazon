package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
    private int disponibilidad;
    @Column(nullable = false)
    private String descripcion;


    @ManyToMany
    @JoinTable(name = "comentario",
            joinColumns = @JoinColumn(name = "cedula_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_publicacion")
    )
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "moderadores")
    private List<Moderador> moderadores;

    @ManyToMany(mappedBy = "compras")
    private List<Compra> compras;

    @ManyToMany(mappedBy = "favoritos")
    private List<Usuario> favoritos;
}
