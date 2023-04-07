package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.jakarta.persistence.Compra;
import co.edu.uniquindio.proyecto.jakarta.persistence.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select p from Compra p where p.codigo = :codigoCompra")
    List<Compra> listarCompras(int codigoCompra);



        // Compra save(Compra compra);

        /////ola
      //  List<Compra> findByCodigoUsuario ( int codigoUsuario);


}