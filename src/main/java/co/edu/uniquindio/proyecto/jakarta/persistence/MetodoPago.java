package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

public enum MetodoPago {
    NEQUI,
    VISA,
    MASTERCARD,
    DAVIPLATA,
    CREDITO,
}
