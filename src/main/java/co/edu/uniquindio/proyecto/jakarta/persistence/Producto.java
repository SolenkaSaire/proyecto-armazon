package co.edu.uniquindio.proyecto.jakarta.persistence;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private String disponibilidad;
    private LocalDate fechaLimite;
    private Comentario comentario;
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Categoria> categoria;

}
