package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public enum Categoria {


    TECNOLOGIA,
    HOGAR,
    COCHES,
    PINTURA,
    herramientas;


     @ManyToOne
     @JoinColumn(nullable = false)
     private Producto producto;

/////////////////////////////////7
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

}