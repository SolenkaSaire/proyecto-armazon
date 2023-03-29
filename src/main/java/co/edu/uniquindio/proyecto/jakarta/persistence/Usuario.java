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
public class Usuario extends Cuenta implements Serializable {

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false,length = 50)
    private String apellido;

    @Column(nullable = false,length = 50)
    private String direccion;

    @Column(length = 10)
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;//publicacionProductos?

    @OneToMany(mappedBy = "vendedor")
    private List<PublicacionProducto> misProductos;

    @ManyToMany
    private List<PublicacionProducto> publicacionesFavoritas;//publicacionProductos?

    @OneToMany(mappedBy="usuario")
    private List<Compra> compra;//publicacionProductos?


    /////////////////////




}