package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping("/crear")
    public int crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return usuarioServicio.crearUsuario(usuarioDTO);

    }

    @PutMapping("/actualizar/{codigo}")
    public int actualizarUsuario(@RequestBody int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception{
        return usuarioServicio.actualizarUsuario(codigoUsuario,usuarioDTO);

    }

    @DeleteMapping("/eliminar/{codigo}")
    public int eliminiarUsuario(@RequestBody int codigoUsuario) throws Exception {
        return usuarioServicio.eliminiarUsuario(codigoUsuario);
    }

    @GetMapping("/obtener/{codigo}")
    Usuario obtenerUsuario1(@PathVariable int codigo) throws Exception{
        return usuarioServicio.obtenerUsuario(codigo);
    }
}






