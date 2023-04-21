package co.edu.uniquindio.proyecto.servicios.excepciones;

import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;

import java.util.List;
import java.util.Optional;

public class AttributeException extends Exception {

    private UsuarioRepo usuarioRepo;
    public AttributeException(String mensaje) {
        super(mensaje);
    }

}