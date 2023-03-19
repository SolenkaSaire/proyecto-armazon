package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

public enum Estado implements Serializable {
    APROBADO(0), NO_APROBADO(1);

    private int nombre;

    private Estado(int numeroEstado) {
        this.nombre = numeroEstado;
    }

    public int getnumeroEstado() {
        return nombre;
    }


}