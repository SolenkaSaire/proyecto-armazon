package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.Compra;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO) throws Exception;


    List<CompraGetDTO> listarMisCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra) throws Exception;




}