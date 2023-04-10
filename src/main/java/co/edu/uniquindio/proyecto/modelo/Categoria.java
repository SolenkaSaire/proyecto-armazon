package co.edu.uniquindio.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


public enum Categoria {

    TECNOLOGIA,
    HOGAR,
    COCHES,
    PINTURA,
    HERRAMIENTAS;


}