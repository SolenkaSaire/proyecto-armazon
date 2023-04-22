package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, "Producto creado exitosamente! Código: "+ productoServicio.crearProducto(productoDTO)) );
    }

    @PutMapping("/actualizarProductos/{codigo}")
    int actualizarProducto(@PathVariable int codigoProducto,@RequestBody ProductoDTO productoDTO) throws Exception{
        return productoServicio.actualizarProducto(codigoProducto,productoDTO);
    }

    @PutMapping("/actualizarUnidades/{codigo}")
    int actualizarUnidades(@PathVariable int codigoProducto,@PathVariable int unidades) throws Exception{
        return productoServicio.actualizarUnidades(codigoProducto,unidades);
    }
/*
    @PutMapping("/actualizarEstado/{codigo}")
    int actualizarEstado(@PathVariable int codigoProducto,@RequestBody Estado estado) throws Exception{
        return productoServicio.actualizarEstado(codigoProducto,estado);
    }*/

    @GetMapping("/obtenerProducto/{codigo}")
    ProductoGetDTO obtenerProducto(@PathVariable int codigoProducto) throws Exception{
        return productoServicio.obtenerProducto(codigoProducto);
    }


}
