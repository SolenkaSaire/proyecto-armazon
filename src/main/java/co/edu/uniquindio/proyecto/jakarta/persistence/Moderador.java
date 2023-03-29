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
public class Moderador  extends Cuenta implements Serializable {

    @OneToMany(mappedBy="moderador")
    private List<ProductoModerador> productoModeradors;

}