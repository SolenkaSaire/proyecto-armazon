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
@ToString(callSuper = true)
public class Usuario extends Cuenta implements Serializable {

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false,length = 100)
    private String apellido;

    @Column(nullable = false,length = 50)
    private String direccion;

    @Column(length = 10)
    private String telefono;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;//publicacionProductos?
    @ToString.Exclude
    @OneToMany(mappedBy = "vendedor")
    private List<PublicacionProducto> misProductos;

    @ToString.Exclude
    @ManyToMany
    private List<PublicacionProducto> publicacionesFavoritas;//publicacionProductos?

    @ToString.Exclude
    @OneToMany(mappedBy="usuario")
    private List<Compra> compra;//publicacionProductos?
}