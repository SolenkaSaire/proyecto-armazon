package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/api/detallecompra")
@AllArgsConstructor
public class DetalleCompraControlador {


    private final DetalleCompraServicio detalleCompraServicio;
    private final CompraServicio compraServicio;

    @GetMapping("/obtenerDetalleCompra/{codigoCompra}")
    public ResponseEntity<MensajeDTO> obtenerDetalleCompra(@PathVariable int codigoCompra) throws Exception {
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, detalleCompraServicio.obtenerDetalleCompra(codigoCompra)));
    }

    @GetMapping("/listarMisCompras/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable int codigoUsuario){
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, detalleCompraServicio.listarProductosUsuario(codigoUsuario)));
    }



}
