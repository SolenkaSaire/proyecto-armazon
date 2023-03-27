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
public class Usuario extends Cuenta implements Serializable {
    @OneToOne
    private Cuenta cuenta;

    /////////////////////// 1 A 1 O SOLO EXTENDS???????
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
    @JoinTable(name = "comentarios",
            joinColumns = @JoinColumn(name = "cedula_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_publicacion")
    )
    @Column(nullable = true)
    private List<PublicacionProducto> comentario;//publicacionProductos?


    @ManyToMany(mappedBy = "favoritos")
    @Column(nullable = true)
    private List<PublicacionProducto> favorito;//publicacionProductos?

    @OneToMany(mappedBy="Usuario")
    @Column(nullable = true)
    private List<Compra> compra;//publicacionProductos?



    /////////////////////




}