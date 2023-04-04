package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Compra;

import java.util.List;

public interface CompraRepo {
    Compra save(Compra compra);

    List<Compra> findByCodigoUsuario(int codigoUsuario);

}
