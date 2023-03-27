package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

//@Entity
public enum Estado implements Serializable {
    APROBADO, NO_APROBADO;



    @ManyToMany
    private List<Moderador> moderadores;

    @ManyToOne
    private ProductoModerador productoModerador;


}