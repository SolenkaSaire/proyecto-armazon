package co.edu.uniquindio.proyecto.jakarta.persistence;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
@Entity
public class Moderador implements Serializable {

    @Id
    private String cedula;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String contraseña;

    public Moderador() {
        super();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moderador moderador = (Moderador) o;

        return cedula.equals(moderador.cedula);
    }

    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
}
