package co.edu.uniquindio.proyecto.modelo;

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
    

}
