package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

public enum MetodoPago {
    NEQUI,
    VISA,
    MASTERCARD,
    DAVIPLATA,
    CREDITO;


    @ManyToOne
    private Compra compra;

}
