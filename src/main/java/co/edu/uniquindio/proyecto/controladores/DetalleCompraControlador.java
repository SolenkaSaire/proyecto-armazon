package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/detallecompra")
@AllArgsConstructor
public class DetalleCompraControlador {


    private final DetalleCompraServicio detalleCompraServicio;

    @GetMapping("/obtenerProducto/{codigo}")
    DetalleCompraDTO obtenerProducto(@PathVariable int codigoCompra){
        return detalleCompraServicio.obtenerProducto(codigoCompra);
    }

}
